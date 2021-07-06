package CucumberTesting.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ProductMakeRequest {

    InputStreamReader in;
    BufferedReader buff;
    String line;
    StringBuilder builder;

    private URL url;

    private static HttpURLConnection connection;

    public ProductMakeRequest() {}

    // TODO: Make get request with out params and body.
    public void getRequest(String url_string){
        try {
            this.url = new URL(url_string);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: Post request with body.
    public String postRequest(String url_string,String data){
        try {
            this.url = new URL(url_string);

            connection = (HttpURLConnection) url.openConnection();
            // set POST property
            connection.setRequestMethod("POST");
            // Send requets content in JSON
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            // Set response type is JSON
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);
            // Create request BODY

            OutputStream os = connection.getOutputStream();
            os.write(data.getBytes(StandardCharsets.UTF_8));
            os.close();

            in = new InputStreamReader((InputStream) connection.getContent());

            buff = new BufferedReader(in);

            builder = new StringBuilder();

            do {
                line = buff.readLine();
                if (line != null){
                    builder.append(line);
                } else {
                    break;
                }
            } while (line != null);

            buff.close();

            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Can't add to DB";

    }

    public JSONObject getContent(){
        try {

            in = new InputStreamReader((InputStream) connection.getContent());
            buff = new BufferedReader(in);

            builder = new StringBuilder();

            do {
                line = buff.readLine();
                builder.append(line).append("\n");
            } while (line != null);

            buff.close();

            return new JSONObject(builder.toString());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }

    public int getStatusCode(){

        try {
            return connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 404;
    }

    // TODO: Delete maping request
    public void delete(Integer productCode){
        try {
            this.url = new URL("http://localhost:8080/product/delete/" + productCode);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
