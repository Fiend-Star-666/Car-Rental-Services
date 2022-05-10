package com.intern.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.VehicleLogRepository;
import com.intern.carRental.primary.CarRentalLocation;
import com.intern.carRental.primary.VehicleLog;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleLogController {
	@Autowired
	VehicleLogRepository vehicleLogRepo;
	
	@CrossOrigin
	@GetMapping("/logs/vehicle/view/{id}")
	public List<VehicleLog> vehicleLogByVehicleId(@PathVariable int id){
		 List<VehicleLog> vehicleLogList=vehicleLogRepo.findAllByVehicleId(id);
		 //return
		return vehicleLogList;
	}
	
}

