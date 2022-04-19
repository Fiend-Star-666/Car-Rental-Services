package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import com.intern.carRental.primary.abstrct.Notification;
import com.intern.primary.simplePOJO.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@PrimaryKeyJoinColumn(name="id")
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class SMSNotification extends Notification{
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	private String phonenum;
	private Location address;

	@Override
	public Boolean sendNotification() {
		// TODO Auto-generated method stub
		return null;
	}
}
