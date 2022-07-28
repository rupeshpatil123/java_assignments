package com.product.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.management.Entity.Product;
import com.product.management.Service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService prodService;

	@GetMapping("/prodlist")
	public String findll(Model model) {
		List<Product> prod = prodService.findAll();
		model.addAttribute("PRODUCT", prod);
		return "prodUI/product.html";
	}

	@GetMapping("/addProd")
	public String productForm(Model model) {
		model.addAttribute("PRODUCT", new Product());
		return "prodUI/productForm.html";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("PRODUCT") Product prod) {
		prodService.save(prod);
		return "redirect:/product/prodlist";
	}

	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("prodId") int id, Model model) {
		Product prod = prodService.findById(id);
		model.addAttribute("PRODUCT", prod);
		return "prodUI/productForm.html";
	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("prodId") int id) {
		prodService.deleteById(id);
		return "redirect:/product/prodlist";
	}

}