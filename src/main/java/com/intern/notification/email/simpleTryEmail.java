package com.intern.notification.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class simpleTryEmail {

		public void sending() {//to, subject:(it can be done via enum), message
			
			String from = "travelxperience426@gmail.com";						
			String to = "lkapoor_be18@thapar.edu"; 				
			
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
				
				message.setSubject("Demo Mail");
				message.setText("This is a demo mail from spring boot app");
				
				Transport transport = session.getTransport("smtp");
				transport.connect(host, from, password);					
				transport.sendMessage(message, message.getAllRecipients());			
				transport.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				//System.out.println( e.printStackTrace());
					//Could not convert socket to TLS
			}
		}
}
