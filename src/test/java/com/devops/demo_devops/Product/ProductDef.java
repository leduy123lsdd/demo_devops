package com.devops.demo_devops.Product;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class ProductDef {

    ProductMakeRequest getAllRequest;

    ProductMakeRequest getProductByIdReqeust;

    ProductMakeRequest addNewProduct;

    ProductMakeRequest deleteProduct;

    //TODO: User want to see all product
    @When("click get all product")
    public void  gbclickGetAllProduct() {
        getAllRequest = new ProductMakeRequest();
        getAllRequest.getRequest("http://localhost:8080/product");
    }

    @Then("Status code see all product is {int}")
    public void statusCodeIs(int status) {
        Assertions.assertEquals(status, getAllRequest.getStatusCode());
    }

    //TODO: User want to get product info
    @When("Click into a product, product code is {int}")
    public void clickIntoAProductProductCodeIs(int productCode) {
        getProductByIdReqeust = new ProductMakeRequest();
        getProductByIdReqeust.getRequest("http://localhost:8080/product/" + productCode);
    }

    @Then("Status code get product by product code is {int}")
    public void statusCodeGetProductByProductCodeIs(int status) {
        Assertions.assertEquals(status, getProductByIdReqeust.getStatusCode());
    }

    @And("Product code of data return is {int}")
    public void productCodeOfDataReturnIs(int productCode) {
        JSONObject responseJS = getProductByIdReqeust.getContent();
        try {
            int productCodeRes = (int) responseJS.get("productCode");
            Assertions.assertEquals(productCode, productCodeRes);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //TODO: Store owner want to add a new product
    Map<String,String> data_body;
    String resMessage;

    @Given("new products")
    public void newProducts(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> column : rows) {
            data_body = column;
        }
    }

    @When("user upload product info")
    public void userUploadProductInfo() throws JSONException {
        JSONObject json =  new JSONObject(data_body);

        addNewProduct = new ProductMakeRequest();
        resMessage = addNewProduct.postRequest("http://localhost:8080/product", json.toString());
    }

    @Then("Add product into DB")
    public void addProductIntoDB() {
        Assertions.assertEquals("Add new product successed", resMessage);
    }

    //TODO: Owner delete a product from store
    @When("Click delete product with product code is {int}")
    public void clickDeleteProductWithProductCodeIs(int productCode) {
        deleteProduct = new ProductMakeRequest();
        deleteProduct.delete(productCode);
    }

    @Then("Delete it in DB")
    public void deleteItInDB() {

        Assertions.assertEquals(200,deleteProduct.getStatusCode());
    }



}
