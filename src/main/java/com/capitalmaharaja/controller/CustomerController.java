package com.capitalmaharaja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitalmaharaja.entity.Customer;
import com.capitalmaharaja.service.CustomerService;
import com.capitalmaharaja.util.ResponseUtil;

@RestController
@RequestMapping("controller/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil addCustomer(@RequestBody Customer customer){
		return new ResponseUtil(200,"Customer Added Successfully",customerService.addCustomer(customer));
	}
	
	@GetMapping(path="allCustomers",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getAllCustomer(){
		return new ResponseUtil(200,"Done",customerService.getAllCustomer());
	}
	
	
	@GetMapping(path="singleCustomer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil getCustomer(@PathVariable String id){
		return new ResponseUtil(200,"Done",customerService.getCustomerById(id));
	}
	
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil UpdateCustomer(@RequestBody Customer customer ){
		return new ResponseUtil(200,"Customer Updated Successfully",customerService.updateCustomer(customer));
	}
	
	@DeleteMapping(path="/remove/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseUtil DeleteCustomer(@PathVariable String id){
		return new ResponseUtil(200,"Customer Deleted Successfully",customerService.deleteCustomer(id));
	}


}
