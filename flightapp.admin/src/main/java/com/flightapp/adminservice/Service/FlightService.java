package com.flightapp.adminservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.adminservice.Controller.PlaceRequest;
import com.flightapp.adminservice.Entity.Flight;
import com.flightapp.adminservice.Repo.FlightRepository;
import com.flightapp.adminservice.exception.ScheduledFlightNotFoundException;



@Service
public class FlightService {
	
	@Autowired
	FlightRepository repo;
	
	public Iterable<Flight> getAllFlights()
	{
		return repo.findAll();
	}
	
	public Optional<Flight> getFlightsbyId(Integer flightid) {
		// TODO Auto-generated method stub
		if (repo.findById(flightid)==null) {
			throw new ScheduledFlightNotFoundException("Flight Not Avaiable");
		}
		else {
			return repo.findById(flightid);
		}
	}

	 public Iterable<Flight> getAllFlightbyPlace(PlaceRequest theflight)
	 {
		
		if (repo.findAllByPlace(theflight.getStartplace(),theflight.getEndplace())==null) {
			throw new ScheduledFlightNotFoundException("Flight Not Avaiable");
		}
		else {
			return repo.findAllByPlace(theflight.getStartplace(),theflight.getEndplace());
		}
		
	 }

	 
	 public void addNewFlight(Flight newFlight)
	 {
		 repo.save(newFlight);
	 }
	 
	public void updateFlight(Flight updateFlight) {
		repo.save(updateFlight);
		
	}
	public void deleteFlightById(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch(Exception e) {
			throw new ScheduledFlightNotFoundException("Flight Not Avaiable");
		}
	}
}
