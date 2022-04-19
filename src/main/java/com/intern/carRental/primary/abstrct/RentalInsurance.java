package com.intern.carRental.primary.abstrct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.intern.carRental.primary.VehicleReservation;

import lombok.*;
@Getter
@Setter
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class RentalInsurance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	private String insuranceId;
	
	@ManyToOne(optional = false)
	private VehicleReservation vehiclereservation;
	
	public abstract Boolean addInsurance();
}
