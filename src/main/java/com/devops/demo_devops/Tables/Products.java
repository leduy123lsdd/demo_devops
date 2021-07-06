package com.devops.demo_devops.Tables;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "productcode")
    private int productCode;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productdescription")
    private String productDescription;

    @Column(name = "buyprice")
    private Double buyPrice;

    public Products(int productCode, String productName, String productDescription, Double buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.buyPrice = buyPrice;
    }

    public Products(){}

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

}
