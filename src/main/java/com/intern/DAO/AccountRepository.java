package com.intern.DAO;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intern.carRental.primary.abstrct.Account;
import com.intern.primary.simplePOJO.Person;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	Account findByPersonEmail(String Email);
	
}