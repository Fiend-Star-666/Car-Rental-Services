package com.intern.carRental.primary.abstrct;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.intern.carRental.primary.VehicleReservation;

import lombok.*;

@Getter
@Setter
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class Equipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	private String equipmentId;
	

	public abstract Boolean addEquipment();
	
	@ManyToOne(optional = false)
	private VehicleReservation vehiclereservation;

}
