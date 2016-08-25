package com.schoeninteriors.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoeninteriors.service.ProductService;
import com.schoeninteriros.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/addProduct", method = { RequestMethod.POST, RequestMethod.GET })
	public String addProduct(@ModelAttribute("user") Product product, Model model, HttpServletRequest request) {
		Product dbProduct = productService.addProduct(product);
		if (dbProduct == null) {
			model.addAttribute("error", "Error while adding the product. Please try again");
		}
		return "product/addproduct";
	}

	@RequestMapping(value = "/viewProduct")
	public @ResponseBody List<Product> viewProducts(Model model, HttpServletRequest request) {
		List<Product> products = productService.viewProducts();
		model.addAttribute("products", products);
		return products;
	}

	@RequestMapping(value = "/editProduct", method = { RequestMethod.GET })
	public String editProduct(String productId, Model model, HttpServletRequest request) {
		Product product = productService.editProduct(productId);
		model.addAttribute("product", product);
		return "product/editproduct";
	}

}
