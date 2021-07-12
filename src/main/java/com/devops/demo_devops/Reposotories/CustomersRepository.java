package com.devops.demo_devops.Reposotories;

import com.devops.demo_devops.Tables.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    Optional findById(int customerNumber);
}

