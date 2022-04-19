package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.RentalInsurance;

//@PrimaryKeyJoinColumn(name="id")
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class BelongingInsurance extends RentalInsurance{
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Override
	public Boolean addInsurance() {
		// TODO Auto-generated method stub
		return null;
	}

}
