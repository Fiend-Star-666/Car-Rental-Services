package com.intern.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.CarRentalLocationRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.CarRentalLocation;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.services.impl.VehicleServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CarRentalLocationController {
	@Autowired
	VehicleRepository vehicleRepo;

	@Autowired
	CarRentalLocationRepository carRentalLocationRepo;
	
	@Autowired
	VehicleServiceImpl vehicleServiceImpl;
	
	@CrossOrigin
	@GetMapping("/carrentallocation/vehicle/view/{id}")
	public ResponseEntity<CarRentalLocation> getVehicleParkingStallForVehicle(@PathVariable int id) {
		CarRentalLocation carRentalLocation=vehicleRepo.findById(id).get().getCarRentalLocation();
		return ResponseEntity.ok(carRentalLocation);
	}
	
	@CrossOrigin
	@GetMapping("/carrentallocation/{id}/vehicles")
	public List<Vehicle> getVehiclesOfCarRentalLocation(@PathVariable int id) {
		List<Vehicle> vehicleList=vehicleRepo.findAllByCarRentalLocationId(id);
		return vehicleList;	
	}
	
	@CrossOrigin
	@GetMapping("/carrentallocation/view")
	public List<CarRentalLocation> getCarRentalLocations() {
		List<CarRentalLocation> carRentalLocations=carRentalLocationRepo.findAll();
		return carRentalLocations;
	}
}
