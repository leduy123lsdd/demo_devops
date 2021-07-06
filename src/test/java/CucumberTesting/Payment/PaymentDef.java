package CucumberTesting.Payment;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PaymentDef {

    PaymentMakeRequest findPayment;
    PaymentMakeRequest addPayment;

    @Given("customer number is {int}")
    public void customerNumberIs(int customerNumber) {
        findPayment = new PaymentMakeRequest();
        findPayment.findPaymentByCustomerNumber(customerNumber);
    }

    @Then("payment return with check number is {int} with the nearest purchase.")
    public void payment_return_with_check_number_is_with_the_nearest_purchase(Integer checkNumberExpected) {

        try {
            JSONArray json = new JSONArray(findPayment.getResponse());

            Boolean isExist = false;

            for (int i = 0; i < json.length(); i++){
                int checkNumberRes = json.getJSONObject(i).getInt("checkNumber");
                if (checkNumberExpected == checkNumberRes) {
                    isExist = true;
                }
            }

            if (isExist) {
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Given("customer purchase info")
    public void customerPurchaseInfo(DataTable table) {

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        addPayment = new PaymentMakeRequest();

        for (Map<String, String> column : rows) {
            JSONObject json = new JSONObject(column);

            addPayment.addNewPayment(json.toString());
            System.out.println(addPayment.getResponse());
        }
    }

    @Then("upload status code is {int}")
    public void uploadStatusCodeIs(int statusExpected) throws IOException {
        Assertions.assertEquals(statusExpected, addPayment.getStatusCode());
    }
}
