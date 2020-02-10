package com.service.rest.productservice.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductRow,Long> {

     Optional<ProductRow> findProductByName(String name);
     void deleteByName(String name);
}
