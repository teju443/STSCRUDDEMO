package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Product;
import com.dxc.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProductsDetails()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{PID}")
	public Optional<Product> getProduct(@PathVariable("PID") Long id)
	{
		return productService.getProductById(id);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product)
	{
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{PID}")
	public void updateProduct(@RequestBody Product product,@PathVariable("PID")Long id)
	{
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{PID}")
	public void deleteProduct(@PathVariable("PID")Long id)
	{
		productService.deleteById(id);
	}
}
