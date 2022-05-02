package com.intern.security;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.AccountRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.exception.ResourceNotFoundException;
import com.intern.primary.simplePOJO.Person;
import com.intern.services.impl.VehicleServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin
public class SecurityLoginController {
	
	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	AccountRepository accountRepo;
	
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
   
    @PostMapping("/vehicle/add") 
    public Vehicle addVehicleNow(@RequestBody Vehicle vehicle) {
    	return vehicleRepo.save(vehicle);
        //return ("<h1>Vehicle added</h1>");    
        //Vehicle vehicle, @RequestParam String numberPlate,@RequestParam String stockNumber, @RequestParam int passangerCapacity,@RequestParam boolean hasSunroof
    }
    /*
    @PostMapping("/employees")
    public Vehicle createEmployee(@RequestBody Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }*/
    
    /*
    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable int id){

       Optional<Vehicle> vehicle = vehicleRepo.findById(id);
  
		  if(vehicle.isPresent()) {
			  return vehicle.get();
		  }
		  
		  else{ 
			  	return null;
		   }
    }
    */
    
    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id){
       Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Vehicle not exist id: " + id));
       return ResponseEntity.ok(vehicle);
    }   
    
    @DeleteMapping("/vehicle/delete/{id}")
    public String removeVehicle(@PathVariable int id)
    {
		vehicleRepo.deleteById(id);
		return "deleted";
	}
    
    @PostMapping("/account/register")
    public String registerAccount(@RequestBody Person person,@RequestBody Account account)
    {	account.setPerson(person);
		accountRepo.save(account);
		return "registerd";
	}
	
	
    
}

//Vehicle vehicle, @RequestParam String numberPlate,@RequestParam String stockNumber, @RequestParam int passangerCapacity,@RequestParam boolean hasSunroof


