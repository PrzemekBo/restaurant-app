package com.restaurant.demo.web;

import com.restaurant.demo.repository.TableRepository;
import com.restaurant.demo.services.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/restaurant")
@RestController
public class BookingController {

	@Autowired
	TableRepository guestRepositorty;

	@Autowired
	GuestService guestService;

	@PostMapping("/bookTable")
	public ResponseEntity <?> bookTable(@RequestBody final String json) {
		return guestService.bookTable(json);
	}
}







