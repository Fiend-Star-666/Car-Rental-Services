package com.intern.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.AccountRepository;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.primary.simplePOJO.Person;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
	@Autowired
	AccountRepository accountRepo;
	
	
	@PostMapping("/account/register")
    public String registerAccount(@RequestBody Person person,@RequestBody Account account)
    {	account.setPerson(person);
		accountRepo.save(account);
		return "registerd";
	}
	
}
