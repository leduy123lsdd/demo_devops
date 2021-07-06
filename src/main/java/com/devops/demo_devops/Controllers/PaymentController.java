package com.devops.demo_devops.Controllers;

import com.devops.demo_devops.Reposotories.PaymentsRepository;
import com.devops.demo_devops.Tables.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {
    @Autowired
    PaymentsRepository paymentsRepository;

    // Get payment by customerNumber
    @GetMapping("/payment/{customerNumber}")
    List<Payments> getPayments(@PathVariable int customerNumber) {
        return paymentsRepository.findByCustomerNumber(customerNumber);
    }

    // Add new payment
    @PostMapping("/payment/create")
    Payments newPayment(@RequestBody Map<String, String> body){
        int customerId = Integer.parseInt(body.get("customerNumber"));
        String payment_date = body.get("paymentDate");
        Double amount_price = Double.parseDouble(body.get("amount"));

        Payments payment = new Payments(customerId, payment_date, amount_price);

        paymentsRepository.save(payment);
        return payment;
    }
}
