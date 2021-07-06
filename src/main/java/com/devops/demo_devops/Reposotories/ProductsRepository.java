package com.devops.demo_devops.Reposotories;

import com.devops.demo_devops.Tables.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
