package com.intern.security;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.services.impl.VehicleServiceImpl;

@RestController
public class SecurityLoginController {
	
	@Autowired
	VehicleRepository vehicleRepo;
	
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
   
    @PostMapping("/vehicle/add{vehicle}") 
    public String addVehicleNow(@RequestBody Vehicle vehicle) {
    	vehicleRepo.save(vehicle);
        return ("<h1>Vehicle added</h1>");    
        //Vehicle vehicle, @RequestParam String numberPlate,@RequestParam String stockNumber, @RequestParam int passangerCapacity,@RequestParam boolean hasSunroof
    }
    
    @GetMapping("/vehicle/{id}")
    public String getVehicleById(@PathVariable int id){

       Optional<Vehicle> vehicle = vehicleRepo.findById(id);
  
		  if(vehicle.isPresent()) {
			  return vehicle.toString();
		  }
		  
		  else{ 
			  	return "not found";
		   }
		 
    	
    	
    	  
       
    }
    
    
    
    
}

//Vehicle vehicle, @RequestParam String numberPlate,@RequestParam String stockNumber, @RequestParam int passangerCapacity,@RequestParam boolean hasSunroof


