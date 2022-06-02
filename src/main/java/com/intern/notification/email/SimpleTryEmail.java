package com.intern.notification.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleTryEmail {

		public boolean sending(String recepient, String subject, String body) {//to, subject:(it can be done via enum), message
			System.out.println(recepient);
			System.out.println(subject);
			System.out.println(body);
			String from = "travelxperience426@gmail.com";						
			String to = recepient; 				
			
			String host = "smtp.gmail.com"; 						
			String port = "587";									
			
			//String user = "abraj306@gamil.com";						
			//String password = "Password_of_user";	
			
			String user="travelxperience426@gmail.com";
			String password="pplzaohfvtrapcjf";
			
			Properties properties = System.getProperties();						
			properties.setProperty("mail.smtp.auth", "true");		
			properties.setProperty("mail.smtp.host", host);			
			properties.setProperty("mail.smtp.port", port);			
			properties.setProperty("mail.smtp.user", user);			
			properties.setProperty("mail.smtp.password", password);	
			properties.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
			
			properties.setProperty("mail.smtp.starttls.enable", "true");	
			
			Session session = Session.getDefaultInstance(properties);		
			
			try {
					
				MimeMessage message = new MimeMessage(session);				
				message.setFrom(new InternetAddress(from));
				
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				message.setSubject(subject);
				message.setText(body);
				
				Transport transport = session.getTransport("smtp");
				transport.connect(host, from, password);					
				transport.sendMessage(message, message.getAllRecipients());			
				transport.close();
				return true;
				
				
			}catch(Exception e) {
				
				e.printStackTrace();
				//System.out.println( e.printStackTrace());
					//Could not convert socket to TLS
				return false;
			}
		}
		
}
