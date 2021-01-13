package com.CursoSence.ProductosCategorias.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CursoSence.ProductosCategorias.models.Category;
import com.CursoSence.ProductosCategorias.models.Product;
import com.CursoSence.ProductosCategorias.services.PCService;

@Controller
public class PCController {
	
	private final PCService service;
	
	public PCController(PCService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model)
	{
		//model.addAttribute("categories", service.allCategories());
		
		return "product.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "product.jsp";
		}
		else
		{
			service.saveProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model)
	{
		//model.addAttribute("categories", service.allProducts());
		
		return "category.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "category.jsp";
		}
		else
		{
			service.saveCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String viewProduct(@PathVariable("id")Long id, Model model)
	{
		
		Product p = service.findProduct(id);
		model.addAttribute("categorias", service.allCategories());
		
		model.addAttribute("product", p);
		
		return "viewProduct.jsp";
		
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
	public String updateProduct(@Valid @ModelAttribute("product")Product product, BindingResult result)
	{
		Product p = service.findProduct(product.getId());
		List<Category> list = p.getCategories();
		
		list.add(product.getCategories().get(0));
		product.setCategories(list);
		
		if(result.hasErrors())
		{
			return "viewProduct.jsp";
		}
		else
		{
			service.updateProduct(product);
			return "redirect:/products/"+product.getId();
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id")Long id, Model model)
	{
		model.addAttribute("productos", service.allProducts());
		model.addAttribute("category", service.findCategory(id));
		
		return "viewCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.PUT)
	public String updateCategory(@Valid @ModelAttribute("category")Category category, BindingResult result)
	{
		Category p = service.findCategory(category.getId());
		List<Product> list = p.getProducts();
		
		list.add(category.getProducts().get(0));
		category.setProducts(list);
		
		if(result.hasErrors())
		{
			return "viewCategory.jsp";
		}
		else
		{
			service.updateCategory(category);
			return "redirect:/categories/"+category.getId();
		}
	}
}
