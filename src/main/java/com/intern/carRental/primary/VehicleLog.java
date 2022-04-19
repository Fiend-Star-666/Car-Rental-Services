package com.intern.carRental.primary;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.intern.carRental.primary.abstrct.Vehicle;
import com.intern.primary.enums.VehicleLogType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String vehiclelogid;
	
	@Enumerated(EnumType.STRING)
	private VehicleLogType type;
	
	private String descriptoin;
	private Date creationDate;
	
	@ManyToOne(optional = false)
	private Vehicle vehicle;
	
	
	public ArrayList<VehicleLogType> searchByLogtype(){
		//TODO searchByLogType
		return null;
	}

}
