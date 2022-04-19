package com.intern.services.impl;

import com.intern.DAO.AccountRepository;
import com.intern.DAO.CarRentalLocationRepository;
import com.intern.DAO.CarRentalSystemRepository;
import com.intern.DAO.MemberRepository;
import com.intern.DAO.ParkingStallRepository;
import com.intern.DAO.ReceptionistRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.CarRentalLocation;
import com.intern.carRental.primary.CarRentalSystem;
import com.intern.carRental.primary.Member;
import com.intern.carRental.primary.ParkingStall;
import com.intern.carRental.primary.Receptionist;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.carRental.primary.vehicletypes.Car;
import com.intern.services.AccountServices;

public class AccountServiceImpl implements AccountServices {
	
	private AccountRepository accountRepo;
	private MemberRepository memberRepo;
	private ReceptionistRepository receptionistRepo;
	
	//supplementary
	private VehicleRepository vehicleRepo;
	private CarRentalSystemRepository carRentalSystemRepo;
	private CarRentalLocationRepository carRentalLocationRepo;
	private ParkingStallRepository parkingStallRepo;
	
		
	public AccountServiceImpl(AccountRepository accountRepo,
			  MemberRepository memberRepo,
			  ReceptionistRepository receptionistRepo,
			  CarRentalLocationRepository carRentalLocationRepo,
			  CarRentalSystemRepository carRentalSystemRepo,
			  ParkingStallRepository parkingStallRepo,
			  VehicleRepository vehicleRepo) 
	{
		super();

		this.accountRepo=accountRepo;
		this.memberRepo=memberRepo;
		this.receptionistRepo=receptionistRepo;
		
		this.carRentalLocationRepo = carRentalLocationRepo;
		this.carRentalSystemRepo = carRentalSystemRepo;
		this.parkingStallRepo = parkingStallRepo;
		
		this.vehicleRepo = vehicleRepo;
		
	}
	
	
	@Override
	public void createAccount(Account account) {
		if (account instanceof Member) {
			Member member = (Member) account;
			memberRepo.save(member);
			
		}
		
		if (account instanceof Receptionist) {
			Receptionist receptionist = (Receptionist) account;
			receptionistRepo.save(receptionist);
		}
	}

	@Override
	public void updateAccount(Account updatedAccount) {
		// TODO use this to create these services
		if (updatedAccount instanceof Member) {
			
			Member newMember = (Member) updatedAccount;
			Member oldMember = (Member) accountRepo.findByPerson(updatedAccount.getPerson().getEmail());
			
			
			oldMember.setPerson(newMember.getPerson());
			
			oldMember.setDriverLicenseNumber(newMember.getDriverLicenseNumber());
			oldMember.setDriverLicenseExpiry(newMember.getDriverLicenseExpiry());
			
			oldMember.setPassword(newMember.getPassword());
			
			oldMember.setVehicle(newMember.getVehicle());
			oldMember.setVehiclereservation(newMember.getVehiclereservation());
			
			oldMember.setASstatus(newMember.getASstatus());
			
			memberRepo.save(oldMember);
			System.out.println("Member saved");

		}
		
		if (updatedAccount instanceof Receptionist) {
			Receptionist newReceptionist = (Receptionist) updatedAccount;
			Receptionist oldReceptionist = (Receptionist)accountRepo.findByPerson(updatedAccount.getPerson().getEmail());
			

			oldReceptionist.setPerson(newReceptionist.getPerson());
			
			oldReceptionist.setDateJoined(newReceptionist.getDateJoined());
			
			oldReceptionist.setPassword(newReceptionist.getPassword());
			
			oldReceptionist.setVehicle(newReceptionist.getVehicle());
			oldReceptionist.setVehiclereservation(newReceptionist.getVehiclereservation());
			
			oldReceptionist.setASstatus(newReceptionist.getASstatus());
			
			receptionistRepo.save(oldReceptionist);
			System.out.println("Receptionist saved");
			
		}
			
	}

	@Override
	public void cancelAccount(String accountEmail) {
		// TODO use this to create these services
		
		/*
		Object vehicle= vehicleRepo.findByBarcode(barcode);
		
		if (vehicle instanceof Car) {
			
			Car newVehicle = (Car) vehicle;
			ParkingStall parkingStall= newVehicle.getParkingstall();
			CarRentalLocation carRentalLocation= newVehicle.getCarRentalLocation();
			CarRentalSystem carRentalSystem = carRentalLocation.getCarRentalSystem();
			
		//for testing
		
			//System.out.println("ID:"+parkingStall.getId());
			vehicleRepo.deleteById(newVehicle.getId());
			
			//System.out.println("ID_location:"+carRentalLocation.getId());
			carRentalLocationRepo.deleteById(carRentalLocation.getId());
			
			//System.out.println("ID_system:"+carRentalSystem.getId());
			carRentalSystemRepo.deleteById(carRentalSystem.getId());
			
			//System.out.println("ID_parkingStall:"+parkingStall.getId());
			parkingStallRepo.deleteById(parkingStall.getId());
			
		}*/

		
	}
	
	
}
