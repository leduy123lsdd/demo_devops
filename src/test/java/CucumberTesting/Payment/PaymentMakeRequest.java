package CucumberTesting.Payment;

import com.devops.demo_devops.Tables.Payments;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PaymentMakeRequest {
    private URL url;
    InputStreamReader in;
    BufferedReader buff;
    String line;
    StringBuilder builder;
    private static HttpURLConnection connection;

    public PaymentMakeRequest() {}

    // TODO: Find payment by customerNumber
    public void findPaymentByCustomerNumber(int customerNumber) {
        try {
            this.url = new URL("http://localhost:8080/payment/"+customerNumber);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: Add new payment by customer
    public void addNewPayment(String data){
        try {
            this.url = new URL("http://localhost:8080/payment/create");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(data.getBytes(StandardCharsets.UTF_8));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: get response
    public String getResponse(){
        try {

            in = new InputStreamReader((InputStream) connection.getContent());
            buff = new BufferedReader(in);

            builder = new StringBuilder();

            do {
                line = buff.readLine();
                if (line == "null") {
                    break;
                }
                builder.append(line).append("\n");
            } while (line != null);

            buff.close();

            return builder.toString();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public int getStatusCode() throws IOException {
        return connection.getResponseCode();
    }
}
