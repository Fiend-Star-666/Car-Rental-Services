package com.intern.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.CarRentalSystemRepository;
import com.intern.carRental.primary.CarRentalSystem;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CarRentalSystemController {
	@Autowired
	CarRentalSystemRepository carRentalSystemRepo;

	@CrossOrigin
	@GetMapping("/home/system")
	public List<CarRentalSystem> getCRSystems() {
		List<CarRentalSystem> carRentalSystems=carRentalSystemRepo.findAll();
		return carRentalSystems;
	}
}
