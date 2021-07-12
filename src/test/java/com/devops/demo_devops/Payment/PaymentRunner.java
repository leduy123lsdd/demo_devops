package com.devops.demo_devops.Payment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/devops/demo_devops/Payment"
)
public class PaymentRunner {
}
