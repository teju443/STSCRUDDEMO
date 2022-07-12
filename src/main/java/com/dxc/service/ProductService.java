package com.dxc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.dxc.model.Product;
import com.dxc.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Cacheable("products")
	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<>();
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		productRepository.findAll().forEach(products::add);
		return products;
		
	}
	
	@Cacheable(value="product" , key="#p0")
	public Optional<Product> getProductById(Long id)
	{
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return productRepository.findById(id);
	}
	
	@CacheEvict(value="products" , allEntries = true)
	public void addProduct(Product product)
	{
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		productRepository.save(product);
	}
	
	@Caching(evict = {
			@CacheEvict(value="products" , allEntries = true),
			@CacheEvict(value="product" , key="#p0")
	})
	public void updateProduct(Long id,Product product)
	{
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		if(productRepository.findById(id).get()!=null)
		{
			productRepository.save(product);
		}
	}
	
	@Caching(evict = {
			@CacheEvict(value="products" , allEntries = true),
			@CacheEvict(value="product" , key="#p0")
	})
	public void deleteById(Long id)
	{
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		productRepository.deleteById(id);
	}

}
