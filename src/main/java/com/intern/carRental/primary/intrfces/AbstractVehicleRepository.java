package com.intern.carRental.primary.intrfces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.intern.carRental.primary.abstrct.Vehicle;
/*
@NoRepositoryBean
public interface AbstractVehicleRepository<T extends Vehicle> 
	        extends JpaRepository<T, Integer>{

	 @Query("")
	 T findVehicleByType(String type);
	 //select c from Category c join fetch c.events where c.parentCategory.categoryId = 1

}
*/