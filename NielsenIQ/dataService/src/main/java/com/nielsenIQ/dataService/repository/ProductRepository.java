package com.nielsenIQ.dataService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nielsenIQ.dataService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
