package com.devops.demo_devops.Customer;

import com.devops.demo_devops.Reposotories.CustomersRepository;
import com.devops.demo_devops.Tables.Customers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDef {

    @Autowired
    CustomersRepository customersRepository;

    @Given("Customer number is {int}")
    public void customerNumberIs(int customerNumber) {
        System.out.println(customerNumber);

        Optional<Customers> customer = customersRepository.findById(customerNumber);
        System.out.println(customerNumber);
        if (customer.isPresent()) {
            System.out.println("test case here ");
            System.out.println(customer);
        }
    }

    @When("Send request login")
    public void sendRequestLogin() {

    }

    @Then("Notion back is {string}")
    public void notionBackIs(String expectedNotion) {

    }


}
