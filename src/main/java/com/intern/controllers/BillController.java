package com.intern.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.BillItemRepository;
import com.intern.DAO.BillRepository;
import com.intern.DAO.VehicleReservationRepository;
import com.intern.carRental.primary.Bill;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BillController {
	
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	BillItemRepository billItemRepo;
	
	@Autowired
	VehicleReservationRepository vehicleReservationRepo;
	
	@GetMapping("/vehiclereservation/viewbill/{vrId}")
	public List<Object> getAllBillsViaVRId(@PathVariable int vrId){
		
		List<Object> obj= new ArrayList<>();
		
		Bill bill=vehicleReservationRepo.getById(vrId).getBill();
		obj.add(bill);
		
		return obj;
	}

}
