package com.company.M9ChallengeMoritaSara.repository;

import com.company.M9ChallengeMoritaSara.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class CustomerRepository {

    @Repository
    public interface CustomerRepo extends JpaRepository<Customer, Integer> {
        List<Customer> findByState(String state);
    }
}