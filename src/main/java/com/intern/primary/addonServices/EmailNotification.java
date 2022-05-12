package com.intern.primary.addonServices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.intern.carRental.primary.abstrct.Notification;
import com.intern.notification.email.SimpleTryEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@PrimaryKeyJoinColumn(name="id")
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class EmailNotification extends Notification{
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	private String email;

	@Override
	public Boolean sendNotification(String subject, String body) {
		SimpleTryEmail simpleTryEmail = new SimpleTryEmail();
		
		boolean result =  simpleTryEmail.sending(email, subject, body);
		
		return result;
	}
}
