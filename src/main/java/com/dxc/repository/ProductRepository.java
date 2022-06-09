package com.dxc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
