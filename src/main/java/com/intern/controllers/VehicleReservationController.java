package com.intern.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.DAO.AccountRepository;
import com.intern.DAO.CarRentalLocationRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.DAO.VehicleReservationRepository;
import com.intern.carRental.primary.VehicleReservation;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.carRental.primary.abstrct.Vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleReservationController {

	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	VehicleReservationRepository vehicleReservationRepo;
	
	@Autowired
	CarRentalLocationRepository carRentalLocationRepo;
	
	@Autowired
	VehicleRepository vehicleRepo;
	
	@Getter
	@Setter
	@ToString
	class VehicleID{
		int vehicleId;
	}
	
	@GetMapping("/vehiclereservation/account/view/{accId}")
	public List<VehicleReservation> getVehicleReservationList(@PathVariable int accId) {
		
		List<VehicleReservation> vehicleReservation=accountRepo.findById(accId).get().getVehiclereservation();		
		return vehicleReservation;
	}
	
	@GetMapping("/admin/vehiclereservations/view/all")
	public List<VehicleReservation> getVehicleReservationAll(){
			List<VehicleReservation> vehicleReservation=vehicleReservationRepo.findAll();
		return vehicleReservation;
	}
	
	/*
	//TODO
	@GetMapping("/admin/vehiclereservation/carrentallocation/view/{vehicleId}")
	public List<List<VehicleReservation>> getVehicleReservationPerLocation(@PathVariable int crLocationID){
			List<Vehicle> vehicles=carRentalLocationRepo.findById(crLocationID).get().getVehicle();
			//LisList<VehicleReservation> vehicleReservation=new ArrayList<>();
			for (Vehicle vehicle : vehicles) {
				//vehicleReservation.add(vehicle.getVehiclereservation());
			}
/*
 * vehicleReservation: find all
 * 		Then iterate through the id's of list<vehicle> then form a map of carRentalLocaiton id vs vehicleReservation
 *-/
		//return vehicleReservation;
	}
	*/
}

/*
@GetMapping("/vehiclereservation/account/view/{accId}")
public Map<String,List<VehicleReservation>> getVehicleReservationPerAccount(@PathVariable int accId) {
	
	List<VehicleReservation> vehicleReservation=accountRepo.findById(accId).get().getVehiclereservation();	
	Map<String,List<VehicleReservation>> list=new HashMap<>();
	//for (VehicleReservation vehicleR : vehicleReservation) {
		VehicleID carid=new VehicleID();
		/*
	for (VehicleReservation vehicleRes2 : vehicleReservation) {
		System.out.println(vehicleRes2);
	}*-/
	
		int vehicleID=accountRepo.findById(accId).get().getVehicle().getId();
		carid.setVehicleId(accountRepo.findById(accId).get().getVehicle().getId());
		System.out.println(carid.toString());
		list.put(carid.toString(),vehicleReservation);
	//}
	//list.put(listVehicleId,vehicleReservation);
	return list;
	
}
*/