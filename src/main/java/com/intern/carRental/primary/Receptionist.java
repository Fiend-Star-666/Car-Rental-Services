package com.intern.carRental.primary;
import java.util.*;

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
@Getter
@Setter
@Entity
//@PrimaryKeyJoinColumn(name="id")  
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Receptionist extends Account{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private Date dateJoined;
	
    private boolean active;	//security

	
	public void searchMember(String Member) {
		//TODO searchmember
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

	@Override
	public Boolean isAccActive() {
		return active;
	}

}