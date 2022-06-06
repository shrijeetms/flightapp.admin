package com.flightapp.adminservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.adminservice.Entity.Airline;
import com.flightapp.adminservice.Entity.Discount;
import com.flightapp.adminservice.Repo.AirlineRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/flight")
public class AirlineController {

	@Autowired
	AirlineRepo repo;
	
	
	@GetMapping("/airlines")
	Iterable<Airline> getDiscountDetails()
	{
		return repo.findAll();
	}
	
	@PostMapping(value="/airline/add")
	void addCoupon(@RequestBody Airline air)
	{
		repo.save(air);
	}
	
	
}
