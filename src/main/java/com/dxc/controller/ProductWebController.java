package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.model.Product;

@Controller
public class ProductWebController {

	@Autowired
	ProductController productController;
	
	@GetMapping("/")
	public String getAllProducts(Model model)
	{
		List<Product> productslist = productController.getAllProductsDetails();
		model.addAttribute("products",productslist);
		return "list_products";
	}
	
	@GetMapping("/new_product")
	public String addProduct(Product product,Model model)
	{
		model.addAttribute("prod", product);
		return "new_product";
	}
	
	@PostMapping(value="/save_new")
	public String saveProduct(@ModelAttribute ("product") Product product)
	{
		productController.addProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/getupdate_product/{pid}")
	public String getUpdateProduct(@PathVariable("pid") Long id, Model model,Product product)
	{
		model.addAttribute("product", productController.getProduct(id));
		return "update_Product";
	}
	
	@PostMapping("/save_update")
	public String editProduct(@ModelAttribute("product") Product product)
	{
		productController.updateProduct(product, product.getId());
		return "redirect:/";
	}
	
	@GetMapping("/delete_product/{pid}")
	public String deleteProduct(@PathVariable("pid") Long id,@ModelAttribute("product") Product product)
	{
		productController.deleteProduct(id);
		return "redirect:/";
	}
}
