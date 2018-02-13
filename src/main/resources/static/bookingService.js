
	$('#book-form').click(function (){
		
		$.ajax({
			
			url: 'http://localhost:8080/restaurant/bookTable',
			data: JSON.stringify
					({
						
					"guest" : {
						
						'name': $('#name').val(),
						'surname': $('#surname').val(),
						'email': $('#email').val(),
						'number': $('#number').val()
					},	
					
					"table" : {
						'tableType': $('#table_type').val(),
						'reservationTime': $('#reservation_time').val()
					}
					
					}),
		
			contentType: 'application/json',	
			type: 'POST',
			
		})
		.done(function(data) { alert(data); })
		.fail(function(data) { alert(data); })
	})
	
	