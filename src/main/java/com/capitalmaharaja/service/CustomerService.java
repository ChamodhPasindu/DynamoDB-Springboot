package com.capitalmaharaja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capitalmaharaja.entity.Customer;
import com.capitalmaharaja.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Iterable<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}
	
	public Optional<Customer> getCustomerById(String id) {
		return customerRepo.findById(id);
	}
	
	public Customer updateCustomer(Customer customer) {
		boolean isExist=customerRepo.existsById(customer.getId());
		if (!isExist) {
			throw new RuntimeException("Entity Not Found");
		}else {
			return customerRepo.save(customer);
		}
	}
	
	public String deleteCustomer(String id) {
		boolean isExist=customerRepo.existsById(id);
		if (!isExist) {
			throw new RuntimeException("Entity Not Found");
		}else {
			 customerRepo.deleteById(id);
			 return "Deleted";
		}
	}
}
