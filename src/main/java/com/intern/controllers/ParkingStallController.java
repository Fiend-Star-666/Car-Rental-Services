package com.intern.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.ParkingStallRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.ParkingStall;
import com.intern.services.impl.VehicleServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ParkingStallController {
	@Autowired
	VehicleRepository vehicleRepo;

	@Autowired
	ParkingStallRepository parkingStallRepo;
	
	@Autowired
	VehicleServiceImpl vehicleServiceImpl;
	
	@CrossOrigin
	@GetMapping("/parkingstall/vehicle/view/{id}")
	public ResponseEntity<ParkingStall> getVehicleParkingStall(@PathVariable int id) {
		ParkingStall parkingStall=vehicleRepo.findById(id).get().getParkingstall();
		return ResponseEntity.ok(parkingStall);
	}
}
