package com.intern.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.DAO.AccountRepository;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.primary.simplePOJO.Location;
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
	
	@GetMapping("/admin/account/view/all")
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}

	@GetMapping("/account/view/pinfo/{id}")
	public List<Object> getPersonalInfo(@PathVariable int id){
		Account account = accountRepo.findById(id).get();
		List<Object> list= new ArrayList<Object>();
			list.add(account);
		return list;
	}
	
}
