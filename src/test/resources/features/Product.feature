Feature: Test api integration of product api

  Scenario: User want to see all product
    When click get all product
    Then Status code see all product is 200


  Scenario: User want to get product info
      When Click into a product, product code is 123
      Then Status code get product by product code is 200
      And Product code of data return is 123


  Scenario: Store owner want to add a new product
    Given new products
      |productCode|productName|productDescription|buyPrice|
      |34          |Pencil|Made in Vietnam|2.0|
    When user upload product info
    Then Add product into DB

  Scenario: Owner delete a product from store
    When Click delete product with product code is 34
    Then Delete it in DB



