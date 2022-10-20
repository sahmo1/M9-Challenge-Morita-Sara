package com.company.M9ChallengeMoritaSara.repository;

import com.company.M9ChallengeMoritaSara.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    @Repository
    public interface CustomerRepository extends JpaRepository<Customer, Integer> {
        List<Customer> findByState(String state);
    }
