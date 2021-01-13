package com.CursoSence.ProductosCategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.ProductosCategorias.models.Category;
import com.CursoSence.ProductosCategorias.models.Product;
import com.CursoSence.ProductosCategorias.repositories.CategoryRepository;
import com.CursoSence.ProductosCategorias.repositories.ProductRepository;

@Service
public class PCService {
	
	private final CategoryRepository repositoryC;
	private final ProductRepository repositoryP;
	
	public PCService(CategoryRepository repositoryC, ProductRepository repositoryP)
	{
		this.repositoryC = repositoryC;
		this.repositoryP = repositoryP;
	}
	
	public Category saveCategory(Category category)
	{
		return repositoryC.save(category);
	}
	
	public Product saveProduct(Product product)
	{
		return repositoryP.save(product);
	}
	
	public Category findCategory(Long id)
	{
		Optional<Category> c = repositoryC.findById(id);
		
		if(c.isPresent())
		{
			return c.get() ;
		}
		else 
		{
			return null;
		}
	}
	
	public Product findProduct(Long id)
	{
		Optional<Product> p = repositoryP.findById(id);
		
		if(p.isPresent())
		{
			return p.get() ;
		}
		else 
		{
			return null;
		}
	}
	
	public List<Category> allCategories()
	{
		return (List<Category>) repositoryC.findAll(); 
	}
	
	public List<Product> allProducts()
	{
		return (List<Product>) repositoryP.findAll();
	}
	
	public Product updateProduct(Product product)
	{
		return repositoryP.save(product);
	}
	
	public Category updateCategory(Category category)
	{
		return repositoryC.save(category);
	}

}
