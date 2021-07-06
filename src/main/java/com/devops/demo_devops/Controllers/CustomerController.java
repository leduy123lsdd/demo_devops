package com.devops.demo_devops.Controllers;

import com.devops.demo_devops.Reposotories.CustomersRepository;
import com.devops.demo_devops.Tables.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomersRepository customersRepository;

    // Login
    @PostMapping("/customer/login/{customerNumber}")
    public String login(@PathVariable int customerNumber){
        // Find customer number is true or not
        Optional<Customers> customer = customersRepository.findById(customerNumber);
        if (customer.isPresent()){
            // If customer number is correct, return alert
            return "Login success";
        } else {
            // If customer number isn't correct, return alert
            return "Customer not exist in DB";
        }

    }

    // Create customer
    @PostMapping("/customer/create")
    public String login(@RequestBody Map<String, String> body){
        int customerNumber = Integer.parseInt(body.get("customerNumber"));
        String customerName = body.get("customerName");
        String phone = body.get("phone");
        String addressLine = body.get("addressLine");
        String city = body.get("city");
        String country = body.get("country");


        if (customersRepository.findById(customerNumber).isPresent()) {
            return "Customer number existed";
        } else {
            Customers newCustomer = new Customers(customerNumber, customerName, phone, addressLine, city, country);
            customersRepository.save(newCustomer);
            return "create new customer successes";
        }
    }
}
