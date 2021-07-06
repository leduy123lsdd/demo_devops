package com.devops.demo_devops.Tables;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payments {

    @Column(name = "customernumber")
    private int customerNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checknumber")
    private int checkNumber;

    @Column(name = "paymentdate")
    private String paymentDate;

    @Column(name = "amount")
    private Double amount;

    public Payments(int customerNumber, String paymentDate, Double amount) {
        this.customerNumber = customerNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Payments(){}

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
