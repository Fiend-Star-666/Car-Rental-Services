package com.intern.carRental.primary;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Account;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
//@PrimaryKeyJoinColumn(name="id")
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Member extends Account {
	// a primary key is not needed in a table where a table inherits via primary key join column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
 	
 	private String driverLicenseNumber;
 	private Date driverLicenseExpiry;
 	
 	public List<VehicleReservation> getReservations(){
		//TODO getreservation
 		return null;
 	}

	@Override
	public Boolean resetPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> searchByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> searchByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}	
}