package com.intern.controllers.vehicleType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.carRental.primary.vehicletypes.Car;
import com.intern.controllers.VehicleController;
import com.intern.exception.ResourceNotFoundException;
import com.intern.services.impl.VehicleServiceImpl;



//@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
//public class CarController {
/*
@Autowired
VehicleRepository vehicleRepo;

@Autowired
VehicleServiceImpl vehicleServiceImpl;

@PostMapping("/vehicle/add") 
public Vehicle addVehicleNow(@RequestBody Car vehicle) {
	
	//System.out.println(vehicle.toString());
 vehicleServiceImpl.addVehicle(vehicle);
 
 return vehicle;
 //return vehicleRepo.save(vehicle);
    //return ("<h1>Vehicle added</h1>");    
    //Vehicle vehicle, @RequestParam String numberPlate,@RequestParam String stockNumber, @RequestParam int passangerCapacity,@RequestParam boolean hasSunroof
}

@GetMapping("/vehicle/view/")
public List<Vehicle> getAllVehicles(){
	return vehicleRepo.findAll();
}

@PutMapping("/vehicle/edit/{id}")
public ResponseEntity<Vehicle> editVehicleById(@PathVariable int id){
	//TODO
	
	//Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Vehicle not exist id: " + id));
    return null;
    //ResponseEntity.ok(vehicle);

}



@GetMapping("/vehicle/view/{id}")
public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id){
   Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Vehicle not exist id: " + id));
   //ystem.out.println(vehicle.toString());
   return ResponseEntity.ok(vehicle);
}   


/*
@GetMapping("/vehicle/view/{id}")
public String getVehicleById(@PathVariable int id){
   Vehicle vehicle = vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Vehicle not exist id: " + id));
   
   return vehicle.toString();
}   
*/
/*
@DeleteMapping("/vehicle/delete/{id}")
public String removeVehicle(@PathVariable int id)
{
	vehicleRepo.deleteById(id);
	//vehicleServiceImpl.removeVehicle(id);
	return "deleted";
}
}








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

