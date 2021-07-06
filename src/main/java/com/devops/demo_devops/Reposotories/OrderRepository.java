package com.devops.demo_devops.Reposotories;

import com.devops.demo_devops.Tables.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByCustomerNumber(Integer customerNumber);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE orders od set od.status = :stt where od.orderNumber = :od",
            nativeQuery = true
    )
    void updateOrderStatus(@Param("od") Integer orderNumber,@Param("stt") String status);
}
