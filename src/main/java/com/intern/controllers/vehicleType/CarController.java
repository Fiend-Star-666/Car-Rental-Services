package com.intern.controllers.vehicleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.controllers.VehicleController;
import com.intern.exception.ResourceNotFoundException;

/*

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController implements VehicleController{
	@Autowired
	VehicleRepository vehicleRepo;

	@Override
    @PostMapping("/vehicle/add")
	public Vehicle addVehicleNow(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);		
	}

	@Override
	public ResponseEntity<Vehicle> getVehicleById(int id) {
	       Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Vehicle not exist id: " + id));
	       
	       return ResponseEntity.ok(vehicle);
	}

	@Override
	public String removeVehicle(int id) {
		vehicleRepo.deleteById(id);
		return "deleted";
	}

}
*/