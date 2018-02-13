package com.restaurant.demo.services;

import com.restaurant.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public ResponseEntity<?> addTable() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public void deleteGuestById(Long id) {adminRepository.delete(id);

	}
}




