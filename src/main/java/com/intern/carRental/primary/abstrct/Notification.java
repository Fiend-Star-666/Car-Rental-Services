package com.intern.carRental.primary.abstrct;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.intern.carRental.primary.Bill;
import com.intern.carRental.primary.VehicleReservation;

import lombok.*;

@Getter
@Setter
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	//notificationId is replaces by auto generated id
	//private int notificationId;
	private Date createdOn;
	private String content;
	
	private String phoneNumber;

	
	@OneToOne
	private Bill bill;
	
	@JsonManagedReference(value = "Notif")
	@ManyToOne
	private VehicleReservation vehiclereservation; 
	
	public abstract Boolean sendNotification(String str1, String str2);
	

}
    