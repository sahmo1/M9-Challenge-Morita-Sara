package com.company.M9ChallengeMoritaSara.CustomerRepositoryTest;


import com.company.M9ChallengeMoritaSara.model.Customer;
import com.company.M9ChallengeMoritaSara.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void createGetAndDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Harry");
        customer.setLastName("Potter");
        customer.setEmail("harry_potter@gmail.com");
        customer.setCompany("fjsbova");
        customer.setPhone(1213-456-789);
        customer.setAddress1("1234 hello street");
        customer.setCity("London");
        customer.setPostalCode(12345);
        customer.setCountry("UK");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
        customerRepository.deleteById(customer.getId());
        customer1 = customerRepository.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Harry");
        customer.setLastName("Potter");
        customer.setEmail("harry_potter@gmail.com");
        customer.setCompany("fjsbova");
        customer.setPhone(1213-456-789);
        customer.setAddress1("1234 hello street");
        customer.setCity("London");
        customer.setPostalCode(12345);
        customer.setCountry("UK");

        customer = customerRepository.save(customer);

        customer.setFirstName("Soobin");
        customer.setEmail("txtSB@hybe.com");

        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getCustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("Emma");
        customer.setLastName("Watson");
        customer.setEmail("emmawatson@ymail.com");
        customer.setCompany("Hello");
        customer.setPhone(111-111-111);
        customer.setAddress1("1234 world street");
        customer.setCity("NYC");
        customer.setState("NY");
        customer.setPostalCode(00000);
        customer.setCountry("United States");

        customerRepository.save(customer);

        List<Customer> customerList = customerRepository.findByState("NY");

        assertEquals(customerList.size(), 1);
    }
}