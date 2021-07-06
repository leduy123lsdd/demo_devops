package com.devops.demo_devops.Reposotories;

import com.devops.demo_devops.Tables.Customers;
import com.devops.demo_devops.Tables.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}

