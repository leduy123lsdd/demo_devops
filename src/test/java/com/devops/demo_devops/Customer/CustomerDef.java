package com.devops.demo_devops.Customer;

import com.devops.demo_devops.Reposotories.CustomersRepository;
import com.devops.demo_devops.Tables.Customers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDef {

    @Autowired
    CustomersRepository customersRepository;

    private int customerNumber;
    private Customers customerInfo;

    @Given("Customer number is {int}")
    public void customerNumberIs(int customerNumber) {
        this.customerNumber = customerNumber;

    }

    @When("Get customer info from DB")
    public void getCustomerInfoFromDB() {
        this.customerInfo = (Customers) customersRepository.findById(customerNumber).orElseThrow();
    }

    @Then("customer name is {string}")
    public void customerNameIs(String cusName) {
        Assertions.assertEquals(cusName, customerInfo.getCustomerName());
    }

    @And("Phone number is {string}")
    public void phoneNumberIs(String phoneNumb) {
        Assertions.assertEquals(phoneNumb, customerInfo.getPhone());
    }

    @And("address is {string}")
    public void addressIs(String address) {
        Assertions.assertEquals(address, customerInfo.getAddressLine());
    }

    @And("city is {string}")
    public void cityIs(String city) {
        Assertions.assertEquals(city, customerInfo.getCity());
    }

}
