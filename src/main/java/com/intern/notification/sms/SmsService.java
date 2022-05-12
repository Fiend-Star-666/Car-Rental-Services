package com.intern.notification.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class SmsService {
	
	private final TwilioProperties twilioproperties;
	
	@Autowired
	public SmsService(TwilioProperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
	}
	
	//send message to number
	public String sendsms(SmsRequest smsrequest)
	{
     
		Message message=Message.creator(new PhoneNumber(smsrequest.getNumber()), new PhoneNumber(twilioproperties.getFromNumber()), smsrequest.getMessage()).create();
        return message.getStatus().toString();
        
	
	}

}
