package com.intern;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.intern.DAO.AccountRepository;
import com.intern.DAO.AdditionalDriverRepository;
import com.intern.DAO.BarcodeReaderRepository;
import com.intern.DAO.BarcodeRepository;
import com.intern.DAO.BillItemRepository;
import com.intern.DAO.BillRepository;
import com.intern.DAO.CarRentalLocationRepository;
import com.intern.DAO.CarRentalSystemRepository;
import com.intern.DAO.CarRepository;
import com.intern.DAO.MemberRepository;
import com.intern.DAO.NotificationRepository;
import com.intern.DAO.ParkingStallRepository;
import com.intern.DAO.PaymentRepository;
import com.intern.DAO.ReceptionistRepository;
import com.intern.DAO.VehicleRepository;
import com.intern.DAO.VehicleReservationRepository;
import com.intern.carRental.primary.Barcode;
import com.intern.carRental.primary.BarcodeReader;
import com.intern.carRental.primary.CarRentalLocation;
import com.intern.carRental.primary.CarRentalSystem;
import com.intern.carRental.primary.Member;
import com.intern.carRental.primary.ParkingStall;
import com.intern.carRental.primary.VehicleReservation;
import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.carRental.primary.vehicletypes.Car;
import com.intern.carRental.primary.vehicletypes.Motorcycle;
import com.intern.carRental.primary.vehicletypes.SUV;
import com.intern.carRental.primary.vehicletypes.Truck;
import com.intern.carRental.primary.vehicletypes.Van;
import com.intern.primary.enums.AccountStatus;
import com.intern.primary.enums.CarType;
import com.intern.primary.enums.PaymentStatus;
import com.intern.primary.enums.ReservationStatus;
import com.intern.primary.enums.VanType;
import com.intern.primary.enums.VehicleStatus;
import com.intern.primary.simplePOJO.Location;
import com.intern.primary.simplePOJO.Person;
import com.intern.services.impl.AccountServiceImpl;
import com.intern.services.impl.VehicleReservationImpl;
import com.intern.services.impl.VehicleServiceImpl;


@SpringBootTest
public class ComplexTesting {
	
	//Autowiring Impl
	
	@Autowired
	VehicleServiceImpl vehicleServiceImpl;
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@Autowired
	VehicleReservationImpl vehicleReservationImpl;
	
	//Autowiring Repo:
	
	@Autowired
	private BarcodeReaderRepository barcodeReaderRepo;
	
	@Autowired
	private CarRentalSystemRepository carRentalSystemRepo;	

	@Autowired
	private CarRentalLocationRepository carRentalLocationRepo;
	
	@Autowired 
	private ParkingStallRepository parkingStallRepo;
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private BarcodeRepository barcodeRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ReceptionistRepository receptionistRepo;
	
	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private BillItemRepository billItemRepo;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private AdditionalDriverRepository additionalDriverRepo;
	
	@Autowired
	private NotificationRepository notificationRepo;
	
	@Autowired
	private VehicleReservationRepository vehicleReservationRepo;
	
//______________________________________________
	
	//All variables will be globally Declared
	Car carVehicle1;
	Barcode barCarVehicle1;
	CarRentalSystem carRentalSystem1;
	CarRentalLocation carRentalLocation1;
	Member memCarVehicle1;
	Date date1;
	Date date2;   
	Location address1;          
	Person person1;
	VehicleReservation carVehicle1Reservation;
	BarcodeReader barCodeReaderVehicle1;
	ParkingStall carParkingStallV1;
	
//________________________________________________	
	
	Car carVehicle2;
	Barcode barCarVehicle2;
	CarRentalSystem carRentalSystem2;
	Member memCarVehicle2;
	BarcodeReader barCodeReaderVehicle2;
	CarRentalLocation carRentalLocation2;
	
	Car carVehicle3;
	Barcode barCarVehicle3;
	CarRentalSystem carRentalSystem3;
	CarRentalLocation carRentalLocation3;

	
	Van vanVehicle1;
	Barcode barVanVehicle1;
	CarRentalSystem vanRentalSystem4;
	CarRentalLocation vanRentalLocation4;
	
	Van vanVehicle2;
	Barcode barVanVehicle2;
	CarRentalSystem vanRentalSystem5;
	CarRentalLocation vanRentalLocation5;

	
	Truck truckVehicle1;
	Member memTruckVehicle1;
	Barcode barTruckVehicle1;
	BarcodeReader barCodeReaderTruckVehicle1;
	CarRentalSystem truckRentalSystem6;
	CarRentalLocation truckRentalLocation6;

	
	SUV suvVehicle1;
	Barcode barSuvVehicle1;
	CarRentalSystem suvRentalSystem7;
	CarRentalLocation suvRentalLocation7;

	
	Motorcycle motorcycleVehicle1;
	Barcode barMotorCycleVehicle1;
	CarRentalSystem motorCycleSystem8;
	CarRentalLocation motorCycleLocation8;
	
	

//____________________________________________________________
	
	//Create 10-20 Dates use from other files
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
	String sDate1 = "11/04/2022 12:00";
	
		
	String sDate2 = "15/05/2022 12:00";
	

	String sDate3 = "17/05/2022 14:00";

	
	String sDate4 = "17/05/2022 14:00";
	

	
//________________________________________________________________________________
	
	@Test
	void basicFramework() throws Exception{
	
		/*
		 * fully populated system of the table with 
		 * multiple Vehicles, 
		 * Barcodes and 
		 * their carRentalSystem, CarRentalLocations, ParkingStall 
		 * multiple Members
		 * and Receptionists
		 * Vehicle Reservations
		*/
		
		
		/*
		 * if a Vehicle status is available: 
		 * parking stall 
		 * vehicle
		 * carREntal location and system
		 * no vehicle log	//later
		 * no reservation
		 * no account linkage
		 * 
		 */
		
		/*
		 * if a Vehicle status is reserved: 
		 * parking stall null
		 * vehicle
		 * carREntal location and system
		 * vehicle log	//later
		 * vehicle reservation
		 * account linkage
		 */
		
		/*
		 * if a vehicle status is lost:
		 * almost everything null except necessary stuff
		 */
		
	 //________________________________________

		Date date1 =  dateFormat.parse(sDate1);
			
		Date date2 =  dateFormat.parse(sDate2);
		
		Date date3 =  dateFormat.parse(sDate3);

		address1 = new Location();
		address1.setCity("NOIDA");
		address1.setCountry("INDIA");
		address1.setState("UP");
		address1.setStreetAddress("CHI-2");
		address1.setZipcode("110076");
		
		
		person1 = new Person();
		person1.setEmail("hi@gmail.com");
		person1.setAddress(address1);
		person1.setName("Sherlock");
		person1.setPhone("976689779");
		
		
		carVehicle1 = new Car();
			
		carVehicle1.setType(CarType.Premium);
			carVehicle1.setNumberPlate("ABCD12345");
			carVehicle1.setStockNumber("XXXO09");
			carVehicle1.setPassengerCapacity(4);
			carVehicle1.setBarcode("1111152");
			carVehicle1.setHasSunroof(true);
			carVehicle1.setStatus(VehicleStatus.Available);
			carVehicle1.setModel("Mustang");
			carVehicle1.setMake("Ford");
			carVehicle1.setManufacturingYear(2015);
			carVehicle1.setMileage(12);
			carRentalLocation1=new CarRentalLocation();
			carVehicle1.setCarRentalLocation(carRentalLocation1);
				carRentalSystem1=new CarRentalSystem();
				carRentalSystem1.setName("vehicle1");
				carRentalSystem1.setCarRentalLocation(new ArrayList());
								
					carRentalSystem1.getCarRentalLocation().add(carRentalLocation1);
					
					carRentalSystemRepo.save(carRentalSystem1);
					
				carRentalLocation1.setCarRentalSystem(carRentalSystem1);
				carRentalLocation1.setVehicle(new ArrayList<>());
				carRentalLocation1.getVehicle().add(carVehicle1);
				carRentalLocation1.setName("Pickup Location");
				carRentalLocation1.setAddress(address1);
					carRentalLocationRepo.save(carRentalLocation1);
					
					carVehicle1.getCarRentalLocation().setCarRentalSystem(carRentalSystem1);
				
				carParkingStallV1 = new ParkingStall();
				carParkingStallV1.setLocationIdentifier("12AS");
				carParkingStallV1.setStallNumber("22");
			parkingStallRepo.save(carParkingStallV1);
				
			carVehicle1.setParkingstall(carParkingStallV1);
			carVehicle1.setVehicle_log(null);
			
			carVehicle1.setVehiclereservation(new ArrayList<>());
			
	
		vehicleServiceImpl.addVehicle(carVehicle1);
			
		barCarVehicle1=new Barcode();

			barCarVehicle1.setVehicle(carVehicle1);
			barCarVehicle1.setBarcode(carVehicle1.getBarcode());
			barCarVehicle1.setIssuedAt(null);
			barCarVehicle1.setActive(false);
		
		barcodeRepo.save(barCarVehicle1);
		
	//vaibhav and lokendra ka raita
			memCarVehicle1=new Member();
			memCarVehicle1.setASstatus(AccountStatus.Active);
			memCarVehicle1.setDriverLicenseExpiry(date1);
			memCarVehicle1.setDriverLicenseNumber("123456789");
			memCarVehicle1.setPassword("qwerty");
			memCarVehicle1.setVehicle(carVehicle1);
			memCarVehicle1.setVehiclereservation(new ArrayList<>());
			memCarVehicle1.setPerson(person1);
			
			//id hasnt been set
		accountServiceImpl.createAccount(memCarVehicle1);
			barCodeReaderVehicle1=new BarcodeReader();
			barCodeReaderVehicle1.setBarcode(barCarVehicle1);
			barCodeReaderVehicle1.setRegisteredAt(date2);
			
			barCodeReaderVehicle1.setActive(null);
		  	//id hasnt been set
		barcodeReaderRepo.save(barCodeReaderVehicle1);
		
		carVehicle1Reservation = new VehicleReservation();
			carVehicle1Reservation.setAccount(memCarVehicle1);
		
			
			//dates to check inventory of vehicles
			carVehicle1Reservation.setCreationDate(date1);
			carVehicle1Reservation.setDueDate(date2);
			carVehicle1Reservation.setReturnDate(date3);
			
			//vehicle set
			carVehicle1Reservation.setVehicle(carVehicle1);
			
			//location data+status
			carVehicle1Reservation.setPickupLocationName("Panchkula");
			carVehicle1Reservation.setReturnLocationName("Patiala");
			
			//vehiclereservation1.setAdditionaldriver(new ArrayList<>());
			//vehiclereservation1.getAdditionaldriver().add(additionaldriver1);
			
			//TODO 3rd party stuff
			carVehicle1Reservation.setService(null);
			carVehicle1Reservation.setRentalinsurance(null);
			carVehicle1Reservation.setEquipment(null);
			
			carVehicle1Reservation.setReservationNumber("grlv98");
			
			//billItem();
			
			carVehicle1Reservation.setBill(null);
			
			//Payment();
			
			/*
			if(payment1.getStatus().equals(PaymentStatus.Completed)){
				vehiclereservation1.setRSstatus(ReservationStatus.Confirmed);
			}*/
			
			//notification();
			
			carVehicle1Reservation.setNotification(null);
			carVehicle1Reservation.setRSstatus(ReservationStatus.Pending);
			//vehiclereservation1.setNotification(new ArrayList<>());
			
			//vehiclereservation1.getNotification().add(webnotification);
			//vehiclereservation1.getNotification().add(mobilenotification);
			
			
			//billRepo.save(bill1);
			
			//billItemRepo.save(billItem1);
			//billItemRepo.save(billItem2);
			
			//paymentRepo.save(payment1);
			
			vehicleReservationImpl.makeReservation(carVehicle1Reservation);
			
			//additionalDriverRepo.save(additionaldriver1);
			
			//notificationRepo.save(mobilenotification);
			//notificationRepo.save(webnotification);
			
			carVehicle1.getVehiclereservation().add(carVehicle1Reservation);
			vehicleServiceImpl.updateVehicle(carVehicle1);
			
	//________________________________________		
		/*
		carVehicle2 = new Car();
		
		carVehicle2.setType(CarType.FullSize);
			carVehicle2.setNumberPlate("CH01BC4421");
			carVehicle2.setStockNumber("XVYZ336");
			carVehicle2.setPassengerCapacity(5);
			carVehicle2.setBarcode("9658W4");
			carVehicle2.setHasSunroof(true);
			carVehicle2.setStatus(VehicleStatus.Available);
			carVehicle2.setModel("ETIOS");
			carVehicle2.setMake("Toyota");
			carVehicle2.setManufacturingYear(2018);
			carVehicle2.setMileage(17);
			carVehicle2.setCarRentalLocation(carRentalLocation2);
				carRentalLocation2.setCarRentalSystem(carRentalSystem2);
					carRentalLocation2.setVehicle(new ArrayList<>());
					carRentalLocation2.getVehicle().add(carVehicle1);
					
					carRentalLocation2.setName(null);
					carRentalLocation2.setAddress(null);
			
			
				carVehicle2.getCarRentalLocation().setCarRentalSystem(carRentalSystem2);
			carVehicle2.setParkingstall(null);
			carVehicle2.setVehicle_log(null);
			carVehicle2.setVehiclereservation(null);
			
			
			
		vehicleServiceImpl.addVehicle(carVehicle2);
			
		barCarVehicle2=new Barcode();

			barCarVehicle2.setVehicle(carVehicle2);
			barCarVehicle2.setBarcode(carVehicle2.getBarcode());
			barCarVehicle2.setIssuedAt(null);
			barCarVehicle2.setActive(false);
			barcodeRepo.save(barCarVehicle2);
			
		memCarVehicle2=new Member();
			memCarVehicle2.setASstatus(AccountStatus.Active);
			memCarVehicle2.setDriverLicenseExpiry(date1);
			memCarVehicle2.setDriverLicenseNumber("123456789");
			memCarVehicle2.setPassword("qwerty");
			memCarVehicle2.setVehicle(carVehicle1);
			memCarVehicle2.setVehiclereservation(new ArrayList<>());
			//id hasnt been set
		memberRepo.save(memCarVehicle2);
		
		barCodeReaderVehicle2=new BarcodeReader();
		  	barCodeReaderVehicle2.setActive(null);
		  	barCodeReaderVehicle2.setBarcode(barCarVehicle2);
			barCodeReaderVehicle2.setRegisteredAt(date2);
			//id hasnt been set
		barcodeReaderRepo.save(barCodeReaderVehicle2);
			
			
			
		
		
			
	//________________________________________
		
		carVehicle3 = new Car();
			
		carVehicle3.setType(CarType.FullSize);
			carVehicle3.setNumberPlate("CH01BZ4421");
			carVehicle3.setStockNumber("KLMZ336");
			carVehicle3.setPassengerCapacity(5);
			carVehicle3.setBarcode("98HYTQ");
			carVehicle3.setHasSunroof(true);
			carVehicle3.setStatus(VehicleStatus.Reserved);
			carVehicle3.setModel("VERNA");
			carVehicle3.setMake("Hyundai");
			carVehicle3.setManufacturingYear(2019);
			carVehicle3.setMileage(17);
			carVehicle3.setCarRentalLocation(null);
				carVehicle3.getCarRentalLocation().setCarRentalSystem(null);
			carVehicle3.setParkingstall(null);
			carVehicle3.setVehicle_log(null);
			carVehicle3.setVehiclereservation(null);
			
		vehicleServiceImpl.addVehicle(carVehicle3);
			
		barCarVehicle3=new Barcode();

			barCarVehicle3.setVehicle(carVehicle3);
			barCarVehicle3.setBarcode(carVehicle3.getBarcode());
			barCarVehicle3.setIssuedAt(null);
			barCarVehicle3.setActive(false);
		
		barcodeRepo.save(barCarVehicle3);
		
	//______________________________________
		
		
		vanVehicle1 = new Van();
			
		vanVehicle1.setType(VanType.Passenger);
			vanVehicle1.setNumberPlate("PB01AZ4478");
			vanVehicle1.setStockNumber("AMAZ786");
			vanVehicle1.setPassengerCapacity(6);
			vanVehicle1.setBarcode("LUXDA98");
			vanVehicle1.setHasSunroof(false);
			vanVehicle1.setStatus(VehicleStatus.Lost);
			vanVehicle1.setModel("Omni");
			vanVehicle1.setMake("Maruti Suzuki");
			vanVehicle1.setManufacturingYear(2014);
			vanVehicle1.setMileage(15);
			vanVehicle1.setCarRentalLocation(null);
				vanVehicle1.getCarRentalLocation().setCarRentalSystem(null);
			vanVehicle1.setParkingstall(null);
			vanVehicle1.setVehicle_log(null);
			vanVehicle1.setVehiclereservation(null);
			
		vehicleServiceImpl.addVehicle(vanVehicle1);
			
		barVanVehicle1=new Barcode();

			barVanVehicle1.setVehicle(vanVehicle1);
			barVanVehicle1.setBarcode(vanVehicle1.getBarcode());
			barVanVehicle1.setIssuedAt(null);
			barVanVehicle1.setActive(false);
		
		barcodeRepo.save(barVanVehicle1);
		
	//________________________________________
		
		vanVehicle2 = new Van();
		
		vanVehicle2.setType(VanType.Cargo);
			vanVehicle2.setNumberPlate("PB12AA7820");
			vanVehicle2.setStockNumber("AMAG34");
			vanVehicle2.setPassengerCapacity(0);
			vanVehicle2.setBarcode("LPA4A98");
			vanVehicle2.setHasSunroof(true);
			vanVehicle2.setStatus(VehicleStatus.Available);
			vanVehicle2.setModel("Ciaz");
			vanVehicle2.setMake("Maruti Suzuki");
			vanVehicle2.setManufacturingYear(2017);
			vanVehicle2.setMileage(11);
			vanVehicle2.setCarRentalLocation(null);
				vanVehicle2.getCarRentalLocation().setCarRentalSystem(null);
			vanVehicle2.setParkingstall(null);
			vanVehicle2.setVehicle_log(null);
			vanVehicle2.setVehiclereservation(null);
			
		vehicleServiceImpl.addVehicle(vanVehicle2);
			
		barVanVehicle2=new Barcode();

			barVanVehicle2.setVehicle(vanVehicle1);
			barVanVehicle2.setBarcode(vanVehicle1.getBarcode());
			barVanVehicle2.setIssuedAt(null);
			barVanVehicle2.setActive(false);
		
		barcodeRepo.save(barVanVehicle2);
		
	//________________________________________
				
		truckVehicle1 =  new Truck();
			
		truckVehicle1.setType("Special");
			truckVehicle1.setNumberPlate("DL3CAA7820");
			truckVehicle1.setStockNumber("ZZ12RT1");
			truckVehicle1.setPassengerCapacity(10);
			truckVehicle1.setBarcode("123456ASDT");
			truckVehicle1.setHasSunroof(false);
			truckVehicle1.setStatus(VehicleStatus.Available);
			truckVehicle1.setModel("BHEN KI LORRY");
			truckVehicle1.setMake("EICHER");
			truckVehicle1.setManufacturingYear(2018);
			truckVehicle1.setMileage(7);
			truckVehicle1.setCarRentalLocation(truckRentalLocation6);
				truckVehicle1.getCarRentalLocation().setCarRentalSystem(truckRentalSystem6);
				truckRentalLocation6.setVehicle(new ArrayList<>());
					truckRentalLocation6.getVehicle().add(truckVehicle1);
					
					truckRentalLocation6.setName(null);
					truckRentalLocation6.setAddress(null);
					truckVehicle1.getCarRentalLocation().setCarRentalSystem(truckRentalSystem6);
			truckVehicle1.setParkingstall(null);
			truckVehicle1.setVehicle_log(null);
			truckVehicle1.setVehiclereservation(null);
			//To check   carRentalsystem1
				
			vehicleServiceImpl.addVehicle(truckVehicle1);
	
		
		
		
		barTruckVehicle1=new Barcode();

			barTruckVehicle1.setVehicle(truckVehicle1);
			barTruckVehicle1.setBarcode(barTruckVehicle1.getBarcode());
			barTruckVehicle1.setIssuedAt(null);
			barTruckVehicle1.setActive(false);
	
		barcodeRepo.save(barTruckVehicle1);
		
		memTruckVehicle1 =new Member();
			memTruckVehicle1.setASstatus(AccountStatus.Active);
			memTruckVehicle1.setDriverLicenseExpiry(date1);
			memTruckVehicle1.setDriverLicenseNumber("123456789");
			memTruckVehicle1.setPassword("qwerty");
			memTruckVehicle1.setVehicle(truckVehicle1);
			memTruckVehicle1.setVehiclereservation(new ArrayList<>());
			//id hasnt been set
		memberRepo.save(memTruckVehicle1);
		
		
			barCodeReaderTruckVehicle1=new BarcodeReader();
		  	barCodeReaderTruckVehicle1.setActive(null);
		  	barCodeReaderTruckVehicle1.setBarcode(barCarVehicle1);
			barCodeReaderTruckVehicle1.setRegisteredAt(date2);
			//id hasnt been set
		barcodeReaderRepo.save(barCodeReaderTruckVehicle1);
		
		

		

	//________________________________________
		
		suvVehicle1 =  new SUV();
			
		suvVehicle1.setType("Special");
			suvVehicle1.setNumberPlate("CH03TP5328");
			suvVehicle1.setStockNumber("ZXSA9887");
			suvVehicle1.setPassengerCapacity(8);
			suvVehicle1.setBarcode("9WR643ASFT");
			suvVehicle1.setHasSunroof(false);
			suvVehicle1.setStatus(VehicleStatus.BeingServiced);
			suvVehicle1.setModel("Harrier");
			suvVehicle1.setMake("TATA");
			suvVehicle1.setManufacturingYear(2018);
			suvVehicle1.setMileage(4);
			suvVehicle1.setCarRentalLocation(null);
				suvVehicle1.getCarRentalLocation().setCarRentalSystem(null);
			suvVehicle1.setParkingstall(null);
			suvVehicle1.setVehicle_log(null);
			suvVehicle1.setVehiclereservation(null);
		
		vehicleServiceImpl.addVehicle(motorcycleVehicle1);
		
		barSuvVehicle1=new Barcode();

			barSuvVehicle1.setVehicle(suvVehicle1);
			barSuvVehicle1.setBarcode(barMotorCycleVehicle1.getBarcode());
			barSuvVehicle1.setIssuedAt(null);
			barSuvVehicle1.setActive(false);
	
		barcodeRepo.save(barMotorCycleVehicle1);
		
	//________________________________________
		
		motorcycleVehicle1 = new Motorcycle();
		
		motorcycleVehicle1.setType("Premium");
			motorcycleVehicle1.setNumberPlate("HR49G4228");
			motorcycleVehicle1.setStockNumber("ASDF0987");
			motorcycleVehicle1.setPassengerCapacity(2);
			motorcycleVehicle1.setBarcode("923QWRASFT");
			motorcycleVehicle1.setHasSunroof(false);
			motorcycleVehicle1.setStatus(VehicleStatus.BeingServiced);
			motorcycleVehicle1.setModel("Fat Bob");
			motorcycleVehicle1.setMake("Harley Davidson");
			motorcycleVehicle1.setManufacturingYear(2018);
			motorcycleVehicle1.setMileage(18);
			motorcycleVehicle1.setCarRentalLocation(null);
				motorcycleVehicle1.getCarRentalLocation().setCarRentalSystem(null);
			motorcycleVehicle1.setParkingstall(null);
			motorcycleVehicle1.setVehicle_log(null);
			motorcycleVehicle1.setVehiclereservation(null);
			
		vehicleServiceImpl.addVehicle(motorcycleVehicle1);
			
		barMotorCycleVehicle1=new Barcode();

			barCarVehicle2.setVehicle(motorcycleVehicle1);
			barCarVehicle2.setBarcode(barMotorCycleVehicle1.getBarcode());
			barCarVehicle2.setIssuedAt(null);
			barCarVehicle2.setActive(false);
		
		barcodeRepo.save(barMotorCycleVehicle1)
		*/
	}
	
	@Test
	void pickingupVehicle() throws Exception{
		/*
		Date date1 =  dateFormat.parse(sDate1);
		
		Date date2 =  dateFormat.parse(sDate2);
		
		Date date3 =  dateFormat.parse(sDate3);

		address1 = new Location();
		address1.setCity("NOIDA");
		address1.setCountry("INDIA");
		address1.setState("UP");
		address1.setStreetAddress("CHI-2");
		address1.setZipcode("110076");
		
		
		person1 = new Person();
		person1.setEmail("hi@gmail.com");
		person1.setAddress(address1);
		person1.setName("Sherlock");
		person1.setPhone("976689779");
		
		
		carVehicle1 = new Car();
			
		carVehicle1.setType(CarType.Premium);
			carVehicle1.setNumberPlate("ABCD12345");
			carVehicle1.setStockNumber("XXXO09");
			carVehicle1.setPassengerCapacity(4);
			carVehicle1.setBarcode("1111152");
			carVehicle1.setHasSunroof(true);
			carVehicle1.setStatus(VehicleStatus.Available);
			carVehicle1.setModel("Mustang");
			carVehicle1.setMake("Ford");
			carVehicle1.setManufacturingYear(2015);
			carVehicle1.setMileage(12);
			carRentalLocation1=new CarRentalLocation();
			carVehicle1.setCarRentalLocation(carRentalLocation1);
				carRentalSystem1=new CarRentalSystem();
				carRentalSystem1.setName("vehicle1");
				carRentalSystem1.setCarRentalLocation(new ArrayList());
								
					carRentalSystem1.getCarRentalLocation().add(carRentalLocation1);
					
					carRentalSystemRepo.save(carRentalSystem1);
					
				carRentalLocation1.setCarRentalSystem(carRentalSystem1);
				carRentalLocation1.setVehicle(new ArrayList<>());
				carRentalLocation1.getVehicle().add(carVehicle1);
				carRentalLocation1.setName("Pickup Location");
				carRentalLocation1.setAddress(address1);
					carRentalLocationRepo.save(carRentalLocation1);
					
					carVehicle1.getCarRentalLocation().setCarRentalSystem(carRentalSystem1);
				
				carParkingStallV1 = new ParkingStall();
				carParkingStallV1.setLocationIdentifier("12AS");
				carParkingStallV1.setStallNumber("22");
			parkingStallRepo.save(carParkingStallV1);
				
			carVehicle1.setParkingstall(carParkingStallV1);
			carVehicle1.setVehicle_log(null);
			
			carVehicle1.setVehiclereservation(new ArrayList<>());
			
	
		vehicleServiceImpl.addVehicle(carVehicle1);
			
		barCarVehicle1=new Barcode();

			barCarVehicle1.setVehicle(carVehicle1);
			barCarVehicle1.setBarcode(carVehicle1.getBarcode());
			barCarVehicle1.setIssuedAt(null);
			barCarVehicle1.setActive(false);
		
		barcodeRepo.save(barCarVehicle1);
		
			memCarVehicle1=new Member();
			memCarVehicle1.setASstatus(AccountStatus.Active);
			memCarVehicle1.setDriverLicenseExpiry(date1);
			memCarVehicle1.setDriverLicenseNumber("123456789");
			memCarVehicle1.setPassword("qwerty");
			memCarVehicle1.setVehicle(carVehicle1);
			memCarVehicle1.setVehiclereservation(new ArrayList<>());
			memCarVehicle1.setPerson(person1);
			
		accountServiceImpl.createAccount(memCarVehicle1);
			
		carVehicle1Reservation = new VehicleReservation();
			carVehicle1Reservation.setAccount(memCarVehicle1);
		
			
			//dates to check inventory of vehicles
			carVehicle1Reservation.setCreationDate(date1);
			carVehicle1Reservation.setDueDate(date2);
			carVehicle1Reservation.setReturnDate(date3);
			
			//vehicle set
			carVehicle1Reservation.setVehicle(carVehicle1);
			
			//location data+status
			carVehicle1Reservation.setPickupLocationName("Panchkula");
			carVehicle1Reservation.setReturnLocationName("Patiala");
			
			carVehicle1Reservation.setService(null);
			carVehicle1Reservation.setRentalinsurance(null);
			carVehicle1Reservation.setEquipment(null);
			
			carVehicle1Reservation.setReservationNumber("grlv98");
			
			
			carVehicle1Reservation.setBill(null);
			
			
			carVehicle1Reservation.setNotification(null);
			carVehicle1Reservation.setRSstatus(ReservationStatus.Pending);
			
			vehicleReservationImpl.makeReservation(carVehicle1Reservation);
			
			
			carVehicle1.getVehiclereservation().add(carVehicle1Reservation);
			vehicleServiceImpl.updateVehicle(carVehicle1);
			*/
//___________________________________________________________________________________________________
			
			/*
			if(payment1.getStatus().equals(PaymentStatus.Completed)){
				vehiclereservation1.setRSstatus(ReservationStatus.Confirmed);
			}*/
			
			//Logic to be Done:
			/*
			 * any member can perform this activity
				 
				 Barcode Reader Scans barcode of the Vehicle
				 
				 Customer is searched via their licence number
				 
				 check if the customer has a valid reservation for the vehicle?
				 	if Yes:
				 		Update Status of vehicle to "Loaned"
				 		
				 		Mark any reservation status to "Completed" that the customer has made against the vehicle
				 		
				 		Send a "Vehicle picked-up" Notification
				 		
				 	if No:
				 		Show Error Message	 
			 */
		
		//vehicle reservation and account connect with vehicle
	    //Payment vehicle log
		
//___________________________________________________________________________________________________
		basicFramework();
			barCodeReaderVehicle1=new BarcodeReader();
			barCodeReaderVehicle1.setBarcode(barCarVehicle1);
			barCodeReaderVehicle1.setRegisteredAt(date2);
			
			barCodeReaderVehicle1.setActive(null);	
			
		barcodeReaderRepo.save(barCodeReaderVehicle1);
		
		Member member2;
		//member2=memberRepo.findBydriverLicenseNumber(memCarVehicle1.getDriverLicenseNumber());
		member2=memberRepo.findBydriverLicenseNumber("123456789");
		
		System.out.println(member2.getVehiclereservation().toString());
		
		
		for(VehicleReservation vehRes:member2.getVehiclereservation()) {
			if(member2.getVehicle().equals(vehRes.getVehicle())){
				
				member2.getVehicle().setStatus(VehicleStatus.Loaned);
				carVehicle1Reservation.setRSstatus(ReservationStatus.Completed);
				
				vehicleServiceImpl.updateVehicle(carVehicle1);
				vehicleReservationImpl.updateReservation(carVehicle1Reservation);
				member2.getVehicle().setParkingstall(null);
				accountServiceImpl.updateAccount(member2);
				//TODO CREATE NOTIFICATION HERE
				
			}
			else {
				System.out.println("Error: No Vehicle Reservation found for this Member");
			}
		}
		
		
}
		
	@Test
	void accident() throws Exception{
		
		/*	
		 * 	Member ne gaadi thok di, receptionist ko call kra and then receptionist ne
		 *	Vehicle log mein change kra accident ka enum
		 */
		
	}
	
	
	@Test
	void returningVehicle() throws Exception{
		
		//Logic to be Done:
		/*
		 * Any Worker can perform this activity.
		 * when Returning a Vehicle, the system must collect a late fee from the 
		 * member if the return date is after the due date			
		 			
		 	Barcode Reader scans the barcode from the Vehicle
		 	
		 	Fetch Vehicle Details
		 	
		 	check if the Vehicle has been returned within the due date?
		 		if Yes:
		 			Go to next Check
		 			
		 		if No:
		 			Calculate Fines and add to the bill
		 			
		 			go to next Check
		 	
		 	
		 	Check if there is any damage to vehicle?
		 		if Yes:
		 			Calculate Fine
		 			
		 			Add Fine to the Bill
		 			
		 			Update Car log
		 			
		 			Go to next check
		 			
		 		if No:
		 			Goto next check
		 			
		 	
		 	Check if the Fuel-Tank is full?
		 		if yes:
		 			Go to next step
		 		
		 		if No:
		 			Calculate fine
		 			
		 			add Fine to the Bill
		 			
		 			Go to next step
		 			
		 	Perform Billing Transaction	
		 	
		 	Create Vehicle return Transaction
		 	
		 	Update Vehicle Status
		 	
		 	Send a Vehicle return Notification
		 */
		
	}
	
}