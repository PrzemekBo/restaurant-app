package com.restaurant.demo.services;

import org.springframework.http.ResponseEntity;

public interface AdminService {
	public ResponseEntity<?> addTable();

	void deleteGuestById(Long id);


}
