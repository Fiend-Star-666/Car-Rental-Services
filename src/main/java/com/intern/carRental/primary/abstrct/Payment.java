package com.intern.carRental.primary.abstrct;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.intern.carRental.primary.Bill;
import com.intern.primary.enums.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)  
public abstract class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date creationDate;
	

	private double amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	public abstract boolean initiateTransaction();
	
	@OneToOne(optional = false)
	private Bill bill;
	

	 

}