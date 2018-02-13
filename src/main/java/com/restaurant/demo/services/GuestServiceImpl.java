package com.restaurant.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.demo.domain.Guest;
import com.restaurant.demo.domain.TableEntity;
import com.restaurant.demo.domain.TableType;
import com.restaurant.demo.repository.TableRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

	@Autowired
	private TableRepository tableRepository;
	@Autowired
	private AvailableService availableService;
	
	@Override
	public  ResponseEntity <?> bookTable(String json)  {
		
		Calendar calendar = GregorianCalendar.getInstance();
		DateFormat format_schema = new SimpleDateFormat("d,MMMM,yyyy,hh:mm");
		Guest guest = new Guest();
		
		TableEntity tableEntity = new TableEntity();
		JSONObject jParser = new JSONObject(json);
		
		JSONObject guestJson = new JSONObject(jParser.get("guest").toString());
		JSONObject tableJson = new JSONObject(jParser.get("table").toString());
		
		String tableType = tableJson.getString("tableType").toString();
		
		try {
			
			if(tableType.equals("quadriple")) {
				tableEntity.setTableType(TableType.QUADRIPLE);
			}else if(tableType.equals("family")) {
				tableEntity.setTableType(TableType.FAMILY);
			}else if(tableType.equals("double")) {
				tableEntity.setTableType(TableType.DOUBLE);
			}else {
				throw new IllegalArgumentException ();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE) .body("Please check your table type");
		}
		
		try {
			guest = new ObjectMapper().readValue(guestJson.toString(), Guest.class);
			String reservation_date =  tableJson.getString("reservationTime").toString();
// Setting up calendar time to reservation time			
			calendar.setTime(format_schema.parse(reservation_date));
// Adding to entity reservation time instance from calendar
			  tableEntity.setDate(new Date(calendar.getTime().getTime()));
// Adding reservation experience time (3 hours)
			    calendar.add(Calendar.HOUR_OF_DAY, 3);
// creating new date from calendar + experience time			
			      Date timestamp = new Date(calendar.getTime().getTime()); 
// Setting to entity reservation  expiration time			
			       tableEntity.setTimestamp(timestamp);
// Checking if guest have required values
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE) .body("Please check your reservation time format");
		}
		
		 if(tableEntity != null && (guest.getSurname() != null && guest.getNumber() != null)) {
		     try {
				availableService.check(tableEntity, guest);
				tableEntity.setGuest(guest);
				tableRepository.save(tableEntity);
		
		    }catch(IllegalArgumentException e) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("No table of that type available at this moment");
			
		    }catch(IllegalStateException e) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("You have already done you reservation");

			}catch(RuntimeException e) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Date now available");
			}
		} 
	
		 
		 return ResponseEntity.status(HttpStatus.OK).body("reservation succesfully done");
	}
}
