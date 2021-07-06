package com.devops.demo_devops.Reposotories;

import com.devops.demo_devops.Tables.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

    List<Payments> findByCustomerNumber(Integer customerNumber);

}