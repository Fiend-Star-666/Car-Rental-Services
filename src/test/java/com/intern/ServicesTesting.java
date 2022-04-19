package com.intern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.intern.services.impl.VehicleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.intern.DAO.AccountRepository;
import com.intern.DAO.BarcodeRepository;
import com.intern.DAO.CarRentalLocationRepository;
import com.intern.DAO.CarRentalSystemRepository;
import com.intern.DAO.MemberRepository;
import com.intern.DAO.ParkingStallRepository;
import com.intern.DAO.ReceptionistRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.carRental.primary.Barcode;
import com.intern.carRental.primary.CarRentalLocation;
import com.intern.carRental.primary.CarRentalSystem;
import com.intern.carRental.primary.Member;
import com.intern.carRental.primary.ParkingStall;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.carRental.primary.vehicletypes.Car;
import com.intern.primary.enums.AccountStatus;
import com.intern.primary.enums.CarType;
import com.intern.primary.enums.VehicleStatus;
import com.intern.primary.simplePOJO.Location;
import com.intern.primary.simplePOJO.Person;

@SpringBootTest
public class ServicesTesting {
	
	//global
	CarRentalSystem carrentalsystem1;
	CarRentalLocation carRentallocation1;
	ParkingStall parkingstall1;
	Car vehicle1;
	Car vehicle2;
	Car vehicle3;
	Barcode barcode1;
	Location address1;
	
	//Global
	@Autowired
	VehicleServiceImpl vehicleServiceImpl ;//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);

	
	
	
	@Autowired
	private CarRentalSystemRepository carRentalSystemRepo;
	
	@Autowired
	private CarRentalLocationRepository carRentalLocationRepo;
	
	@Autowired 
	private ParkingStallRepository parkingStallRepo;
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private BarcodeRepository barcodeRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ReceptionistRepository receptionistRepo;
	
	@Test
 	void carRentalSystem() {
		// CarRentalSystem test
		carrentalsystem1 = new CarRentalSystem();
		carrentalsystem1.setCarRentalLocation(null);
		carrentalsystem1.setName("mohit");
		carRentalSystemRepo.save(carrentalsystem1);
		
	}
	
	@Test
	void carRentalLocation() {
		carRentalSystem();
		
		carRentallocation1 = new CarRentalLocation();
		address1 = new Location();
		address1.setCity("Chandigarh");
		address1.setCountry("India");
		address1.setState("Chandigarh UT");
		address1.setStreetAddress("#164 vahan vihar, Sector 8");
		address1.setZipcode("4165");
		carRentallocation1.setAddress(address1);
		carRentallocation1.setName("Random123");
		carRentallocation1.setVehicle(new ArrayList<>());
		carRentallocation1.setCarRentalSystem(carrentalsystem1);
		carRentalLocationRepo.save(carRentallocation1);
	}
	
	@Test
	void parkingStall() {
		parkingstall1 = new ParkingStall();
		parkingstall1.setLocationIdentifier("A17");
		parkingstall1.setStallNumber("42");
		parkingStallRepo.save(parkingstall1);
		
	}
	
	@Test
	void vehicle() {
		//carRentalSystem();
		//carRentalLocation();
		
		vehicle1 = new Car();
		vehicle1.setLicenseNumber("rf120");
		vehicle1.setStockNumber("an11");
		vehicle1.setPassengerCapacity(4);
		vehicle1.setHasSunroof(true);
		vehicle1.setModel("Car truckk");
		vehicle1.setMake("2001");
		vehicle1.setManufacturingYear(2021);
		vehicle1.setMileage(10);
		vehicle1.setBarcode("77r77");
		vehicle1.setStatus(VehicleStatus.Lost);
		vehicle1.setType(CarType.Economy);
		
	
		carRentalLocation();
		
		vehicle1.setCarRentalLocation(carRentallocation1);
		
		parkingStall();
		
		vehicle1.setParkingstall(parkingstall1);
		vehicleRepo.save(vehicle1);
	}
	
	@Test
	void addingvehicle() {
		//vehicle();
		
		vehicle2 = new Car();
		vehicle2.setLicenseNumber("woofrf120");
		vehicle2.setStockNumber("cat an11");
		vehicle2.setPassengerCapacity(10000000);
		vehicle2.setHasSunroof(true);
		vehicle2.setModel("CarRRRRRR");
		vehicle2.setMake("2001");
		vehicle2.setManufacturingYear(2021);
		vehicle2.setMileage(10);
		vehicle2.setBarcode("7157r77");
		vehicle2.setStatus(VehicleStatus.Lost);
		vehicle2.setType(CarType.Economy);
		
	
		//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem2 = new CarRentalSystem();
			carrentalsystem2.setCarRentalLocation(null);
			carrentalsystem2.setName("kohit");
			carRentalSystemRepo.save(carrentalsystem2);
		
		CarRentalLocation carRentallocation2 = new CarRentalLocation();
		Location address2 = new Location();
		address2.setCity("Chandigarh");
		address2.setCountry("India");
		address2.setState("Chandigarh UT");
		address2.setStreetAddress("#164 vahan vihar, Sector 8");
		address2.setZipcode("4165");
		carRentallocation2.setAddress(address2);
		carRentallocation2.setName("Random123");
		carRentallocation2.setVehicle(new ArrayList<>());
		carRentallocation2.setCarRentalSystem(carrentalsystem2);
		carRentalLocationRepo.save(carRentallocation2);
		
		
		
		vehicle2.setCarRentalLocation(carRentallocation2);
		
	    ParkingStall parkingstall2 = new ParkingStall();
	    
		parkingstall2.setLocationIdentifier("A17");
		parkingstall2.setStallNumber("42");
		
		parkingStallRepo.save(parkingstall2);
		
		vehicle2.setParkingstall(parkingstall2);
		
		
		vehicleServiceImpl.addVehicle(vehicle2);
		
		System.out.println("added");
	}
	
	@Test
	void updatingVehicle(){
		
		//addingvehicle();
		
		
		vehicle2 = new Car();
		vehicle2.setLicenseNumber("woofrf120");
		vehicle2.setStockNumber("cat an11");
		vehicle2.setPassengerCapacity(10000000);
		vehicle2.setHasSunroof(true);
		vehicle2.setModel("CarRRRRRR");
		vehicle2.setMake("2001");
		vehicle2.setManufacturingYear(2021);
		vehicle2.setMileage(10);
		vehicle2.setBarcode("7157r77");
		vehicle2.setStatus(VehicleStatus.Lost);
		vehicle2.setType(CarType.Economy);
		
	
		//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem2 = new CarRentalSystem();
			carrentalsystem2.setCarRentalLocation(null);
			carrentalsystem2.setName("kohit");
			carRentalSystemRepo.save(carrentalsystem2);
		
		CarRentalLocation carRentallocation2 = new CarRentalLocation();
		Location address2 = new Location();
		address2.setCity("Chandigarh");
		address2.setCountry("India");
		address2.setState("Chandigarh UT");
		address2.setStreetAddress("#164 vahan vihar, Sector 8");
		address2.setZipcode("4165");
		carRentallocation2.setAddress(address2);
		carRentallocation2.setName("Random123");
		carRentallocation2.setVehicle(new ArrayList<>());
		carRentallocation2.setCarRentalSystem(carrentalsystem2);
		carRentalLocationRepo.save(carRentallocation2);
		
		
		
		vehicle2.setCarRentalLocation(carRentallocation2);
		
	    ParkingStall parkingstall2 = new ParkingStall();
	    
		parkingstall2.setLocationIdentifier("A17");
		parkingstall2.setStallNumber("42");
		//parkingstall2.setVehicle(vehicle2);
		
		parkingStallRepo.save(parkingstall2);
		
		vehicle2.setParkingstall(parkingstall2);
		
		VehicleServiceImpl vehicleServiceImpl = new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		
		vehicleServiceImpl.addVehicle(vehicle2);
		
		System.out.println("added");
		
		
		//____________________________________________________
		
		vehicle3 = new Car();
		vehicle3.setLicenseNumber("woofrf120");
		vehicle3.setStockNumber("cat an11");
		vehicle3.setPassengerCapacity(5);
		vehicle3.setHasSunroof(true);
		vehicle3.setModel("CarRRRRRR");
		vehicle3.setMake("2001");
		vehicle3.setManufacturingYear(2021);
		vehicle3.setMileage(10);
		vehicle3.setBarcode("7157r77");
		vehicle3.setStatus(VehicleStatus.Lost);
		vehicle3.setType(CarType.Economy);
		
	
		//carRentalLocation();
		
		vehicle3.setCarRentalLocation(carRentallocation2);
		
		//parkingStall();
		
		 ParkingStall parkingstall3 = new ParkingStall();
		    
			parkingstall3.setLocationIdentifier("B17");
			parkingstall3.setStallNumber("424");
			parkingStallRepo.save(parkingstall2);
		
		vehicle3.setParkingstall(parkingstall2);
		
		VehicleServiceImpl vehicleServiceImpl2 = new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		vehicleServiceImpl2.updateVehicle(vehicle3,"7157r77");
		
	}
	
	
	@Test
	void removingVehicle() {
		addingvehicle();
		
		VehicleServiceImpl vehicleServiceImpl1 = new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		vehicleServiceImpl1.removeVehicle("7157r77");
		System.out.println("Removed");
	}
	
	@Test
	void addingTwoVehicle(){
		addingvehicle();
		
		Car vehicle4 = new Car();
		vehicle4.setLicenseNumber("lksh199899");
		vehicle4.setStockNumber("11ss11jj");
		vehicle4.setPassengerCapacity(4);
		vehicle4.setHasSunroof(false);
		vehicle4.setModel("vista");
		vehicle4.setMake("2015");
		vehicle4.setManufacturingYear(2019);
		vehicle4.setMileage(15);
		vehicle4.setBarcode("369llos");
		vehicle4.setStatus(VehicleStatus.Available);
		vehicle4.setType(CarType.Luxury);
		
			//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem3 = new CarRentalSystem();
			carrentalsystem3.setCarRentalLocation(null);
			carrentalsystem3.setName("vohit");
			carRentalSystemRepo.save(carrentalsystem3);
		
		CarRentalLocation carRentallocation3 = new CarRentalLocation();
		Location address3 = new Location();
		address3.setCity("Shimla");
		address3.setCountry("India");
		address3.setState("Himachal Pradesh");
		address3.setStreetAddress("Mall Road");
		address3.setZipcode("696969");
		carRentallocation3.setAddress(address3);
		carRentallocation3.setName("Random58");
		carRentallocation3.setVehicle(new ArrayList<>());
		carRentallocation3.setCarRentalSystem(carrentalsystem3);
		carRentalLocationRepo.save(carRentallocation3);
		
		
		
		vehicle4.setCarRentalLocation(carRentallocation3);
		
	    ParkingStall parkingstall3 = new ParkingStall();
	    
		parkingstall3.setLocationIdentifier("AK47");
		parkingstall3.setStallNumber("44");
		//parkingstall2.setVehicle(vehicle2);
		
		parkingStallRepo.save(parkingstall3);
		
		vehicle4.setParkingstall(parkingstall3);
		
		VehicleServiceImpl vehicleServiceImpl1 = new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		
		vehicleServiceImpl1.addVehicle(vehicle4);
		
		System.out.println("added");
		
	}	
	
	
	@Test
	void addingThreeVehicle(){
		addingTwoVehicle();
		
		Car vehicle5 = new Car();
		vehicle5.setLicenseNumber("DL3CAA1123");
		vehicle5.setStockNumber("11ss11jk");
		vehicle5.setPassengerCapacity(5);
		vehicle5.setHasSunroof(false);
		vehicle5.setModel("vista");
		vehicle5.setMake("2016");
		vehicle5.setManufacturingYear(2012);
		vehicle5.setMileage(18);
		vehicle5.setBarcode("123eloh");
		vehicle5.setStatus(VehicleStatus.Available);
		vehicle5.setType(CarType.Economy);
		
			//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem4 = new CarRentalSystem();
			carrentalsystem4.setCarRentalLocation(null);
			carrentalsystem4.setName("vaibhav");
			carRentalSystemRepo.save(carrentalsystem4);
		
		CarRentalLocation carRentallocation4 = new CarRentalLocation();
		Location address4 = new Location();
		address4.setCity("New Delhi");
		address4.setCountry("India");
		address4.setState("Delhi");
		address4.setStreetAddress("Mall Road");
		address4.setZipcode("110076");
		carRentallocation4.setAddress(address4);
		carRentallocation4.setName("Random59");
		carRentallocation4.setVehicle(new ArrayList<>());
		carRentallocation4.setCarRentalSystem(carrentalsystem4);
		carRentalLocationRepo.save(carRentallocation4);
		
		
		
		vehicle5.setCarRentalLocation(carRentallocation4);
		
	    ParkingStall parkingstall4 = new ParkingStall();
	    
		parkingstall4.setLocationIdentifier("AG34");
		parkingstall4.setStallNumber("49");
		//parkingstall2.setVehicle(vehicle2);
		
		parkingStallRepo.save(parkingstall4);
		
		vehicle5.setParkingstall(parkingstall4);
		
		VehicleServiceImpl vehicleServiceImpl4 =new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		
		vehicleServiceImpl4.addVehicle(vehicle5);
		
		System.out.println("added");
		
	}	
	
	@Test
	void searchingbymodel() {
		vehicle2 = new Car();
		vehicle2.setLicenseNumber("woofrf120");
		vehicle2.setStockNumber("cat an11");
		vehicle2.setPassengerCapacity(10000000);
		vehicle2.setHasSunroof(true);
		vehicle2.setModel("CarRRRRRR");
		vehicle2.setMake("2001");
		vehicle2.setManufacturingYear(2021);
		vehicle2.setMileage(10);
		vehicle2.setBarcode("7157r77");
		vehicle2.setStatus(VehicleStatus.Lost);
		vehicle2.setType(CarType.Economy);
		
	
		//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem2 = new CarRentalSystem();
			carrentalsystem2.setCarRentalLocation(null);
			carrentalsystem2.setName("kohit");
			carRentalSystemRepo.save(carrentalsystem2);
		
		CarRentalLocation carRentallocation2 = new CarRentalLocation();
		Location address2 = new Location();
		address2.setCity("Chandigarh");
		address2.setCountry("India");
		address2.setState("Chandigarh UT");
		address2.setStreetAddress("#164 vahan vihar, Sector 8");
		address2.setZipcode("4165");
		carRentallocation2.setAddress(address2);
		carRentallocation2.setName("Random123");
		carRentallocation2.setVehicle(new ArrayList<>());
		carRentallocation2.setCarRentalSystem(carrentalsystem2);
		carRentalLocationRepo.save(carRentallocation2);
		
		
		
		vehicle2.setCarRentalLocation(carRentallocation2);
		
	    ParkingStall parkingstall2 = new ParkingStall();
	    
		parkingstall2.setLocationIdentifier("A17");
		parkingstall2.setStallNumber("42");
		
		parkingStallRepo.save(parkingstall2);
		
		vehicle2.setParkingstall(parkingstall2);
		
		//VehicleServiceImpl vehicleServiceImpl =new VehicleServiceImpl();//new VehicleServiceImpl(carRentalLocationRepo,carRentalSystemRepo,parkingStallRepo,vehicleRepo);
		
		vehicleServiceImpl.addVehicle(vehicle2);
		
		
		
		
		
		
		
		
		//_____________________________________________________
		
		Car vehicle4 = new Car();
		vehicle4.setLicenseNumber("lksh199899");
		vehicle4.setStockNumber("11ss11jj");
		vehicle4.setPassengerCapacity(4);
		vehicle4.setHasSunroof(false);
		vehicle4.setModel("vista");
		vehicle4.setMake("2015");
		vehicle4.setManufacturingYear(2019);
		vehicle4.setMileage(15);
		vehicle4.setBarcode("369llos");
		vehicle4.setStatus(VehicleStatus.Available);
		vehicle4.setType(CarType.Luxury);
		
			//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem3 = new CarRentalSystem();
			carrentalsystem3.setCarRentalLocation(null);
			carrentalsystem3.setName("vohit");
			carRentalSystemRepo.save(carrentalsystem3);
		
		CarRentalLocation carRentallocation3 = new CarRentalLocation();
		Location address3 = new Location();
		address3.setCity("Shimla");
		address3.setCountry("India");
		address3.setState("Himachal Pradesh");
		address3.setStreetAddress("Mall Road");
		address3.setZipcode("696969");
		carRentallocation3.setAddress(address3);
		carRentallocation3.setName("Random58");
		carRentallocation3.setVehicle(new ArrayList<>());
		carRentallocation3.setCarRentalSystem(carrentalsystem3);
		carRentalLocationRepo.save(carRentallocation3);
		
		
		
		vehicle4.setCarRentalLocation(carRentallocation3);
		
	    ParkingStall parkingstall3 = new ParkingStall();
	    
		parkingstall3.setLocationIdentifier("AK47");
		parkingstall3.setStallNumber("44");

		
		parkingStallRepo.save(parkingstall3);
		
		vehicle4.setParkingstall(parkingstall3);
		
		
		vehicleServiceImpl.addVehicle(vehicle4);
		
		System.out.println("added");
		//______________________________________________________________
		Car vehicle5 = new Car();
		vehicle5.setLicenseNumber("DL3CAA1123");
		vehicle5.setStockNumber("11ss11jk");
		vehicle5.setPassengerCapacity(5);
		vehicle5.setHasSunroof(false);
		vehicle5.setModel("vista");
		vehicle5.setMake("2016");
		vehicle5.setManufacturingYear(2012);
		vehicle5.setMileage(18);
		vehicle5.setBarcode("123eloh");
		vehicle5.setStatus(VehicleStatus.Available);
		vehicle5.setType(CarType.Economy);
		
			//carRentalLocation();
			//carRentalSystem();
			
			CarRentalSystem carrentalsystem4 = new CarRentalSystem();
			carrentalsystem4.setCarRentalLocation(null);
			carrentalsystem4.setName("vaibhav");
			carRentalSystemRepo.save(carrentalsystem4);
		
		CarRentalLocation carRentallocation4 = new CarRentalLocation();
		Location address4 = new Location();
		address4.setCity("New Delhi");
		address4.setCountry("India");
		address4.setState("Delhi");
		address4.setStreetAddress("Mall Road");
		address4.setZipcode("110076");
		carRentallocation4.setAddress(address4);
		carRentallocation4.setName("Random59");
		carRentallocation4.setVehicle(new ArrayList<>());
		carRentallocation4.setCarRentalSystem(carrentalsystem4);
		carRentalLocationRepo.save(carRentallocation4);
		
		
		
		vehicle5.setCarRentalLocation(carRentallocation4);
		
	    ParkingStall parkingstall4 = new ParkingStall();
	    
		parkingstall4.setLocationIdentifier("AG34");
		parkingstall4.setStallNumber("49");
		
		parkingStallRepo.save(parkingstall4);
		
		vehicle5.setParkingstall(parkingstall4);
		
		
		vehicleServiceImpl.addVehicle(vehicle5);
		
		System.out.println("added");
		

		ArrayList<Vehicle> trialVehicle= vehicleRepo.findAllByType(CarType.Luxury.toString());
		System.out.println(trialVehicle.toString());
		
		ArrayList<Vehicle> arr= vehicleServiceImpl.searchByModel("vista");
		
		for(Vehicle var:arr) {
			System.out.println(var.toString());
		}
	}
	
	@Test
	void searchingbytype() {
		//addingThreeVehicle();
		/*
		ArrayList<Vehicle> trialVehicle= vehicleRepo.findAllByType(CarType.Luxury.toString());
		System.out.println(trialVehicle.toString());
		*/
	}
	
	@Test
	void addingAccount() throws Exception {
		Location address2 = new Location();
		address2.setCity("faridabad");
		address2.setCountry("India");
		address2.setState("Haryana");
		address2.setStreetAddress("#198 bharat vihar, Sector 45, Rohini");
		address2.setZipcode("160032");
		
		
		//person Creation
		Person person1=new Person();
		person1.setName("Thor Odinson");
		person1.setPhone("9845621781");
		person1.setEmail("thor123@kries.com");
		person1.setAddress(address2);
		
		Member member1=new Member();
		member1.setPerson(person1);
		member1.setASstatus(AccountStatus.Active);
		member1.setDriverLicenseNumber("485Ad51c");
		
		String sDate3 = "12/01/2029";
		Date date3 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);

		member1.setDriverLicenseExpiry(date3);
		member1.setPassword("Password@123");
		
			//barcodeReader();
		
		//member1.setVehicle(vehicle1);
		//member1.setVehiclereservation(null);
		memberRepo.save(member1);
	}
 
}


 