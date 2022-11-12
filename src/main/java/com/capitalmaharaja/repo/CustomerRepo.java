package com.capitalmaharaja.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capitalmaharaja.entity.Customer;

@Repository
@EnableScan
public interface CustomerRepo extends CrudRepository<Customer, String> {

}
