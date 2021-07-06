package com.devops.demo_devops.Tables;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(name = "customernumber")
    private int customerNumber;

    @Column(name = "customername")
    private String customerName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressline")
    private String addressLine;

    private String city;

    private String country;

    public Customers(){}

    public Customers(int customerNumber ,String customerName, String phone, String addressLine, String city, String country) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
