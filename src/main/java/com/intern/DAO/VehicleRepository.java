package com.intern.DAO;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intern.carRental.primary.abstrct.Vehicle;

//public interface VehicleRepository extends AbstractVehicleRepository<Vehicle>
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	Vehicle findByBarcode(String barcode);
	Vehicle deleteByBarcode(String barcode);
	ArrayList<Vehicle> findAllByModel(String model);
	//ArrayList<Vehicle> findAllByType(String type);
	
}
