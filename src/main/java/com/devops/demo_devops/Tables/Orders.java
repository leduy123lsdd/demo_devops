package com.devops.demo_devops.Tables;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordernumber")
    private int orderNumber;

    @Column(name = "customernumber")
    private int customerNumber;

    @Column(name = "productcode")
    private int productCode;

    @Column(name = "orderdate")
    private String orderDate;

    private String status;

    public Orders(){}

    public Orders(int customerNumber, int productCode, String orderDate, String status) {
        this.customerNumber = customerNumber;
        this.productCode = productCode;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
