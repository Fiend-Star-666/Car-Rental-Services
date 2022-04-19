package com.intern.carRental.primary.vehicletypes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@PrimaryKeyJoinColumn(name="id")  
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Motorcycle extends Vehicle {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	private String type;
	
	@Override
	public Boolean reserveVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean returnVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

}
