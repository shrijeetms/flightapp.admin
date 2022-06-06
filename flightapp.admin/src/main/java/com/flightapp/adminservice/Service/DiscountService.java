package com.flightapp.adminservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.adminservice.Entity.Discount;
import com.flightapp.adminservice.Repo.DiscountRepository;


@Service
public class DiscountService {

	@Autowired
	DiscountRepository repo;
	
	public void addDiscount(Discount coupon) {
		// TODO Auto-generated method stub
		repo.save(coupon);
	}

	public Iterable<Discount> getDiscountdetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteCouponById(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	
}
