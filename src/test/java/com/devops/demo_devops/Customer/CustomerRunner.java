package com.devops.demo_devops.Customer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/devops/demo_devops/Customer"}
)
public class CustomerRunner {
}
