package CucumberTesting.Customer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerDef {

    @Given("customer number \\(id) is {int}")
    public void customerNumberIdIs(int customerNumber) {
        
    }

    @When("Send request login")
    public void sendRequestLogin() {

    }

    @Then("Notion back is {string}")
    public void notionBackIs(String expectedNotion) {

    }
}
