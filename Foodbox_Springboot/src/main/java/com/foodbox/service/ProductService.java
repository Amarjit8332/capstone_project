package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.exception.ProductNotFoundException;
import com.foodbox.model.Product;
import com.foodbox.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productrepo;
	
	public Product addProduct(Product product) {        
        return productrepo.save(product);
    }
	
	public Product getProduct(Long id) {		
		return productrepo.findById(id).get();
	}
	
	public List<Product> findAllProducts(){
		return productrepo.findAll();
	}
	
	public Product updateProduct(Product product) {		
			return productrepo.save(product);		
	}
	
	public Product updateProduct(Product product, Long id) {
		if(product.getId() == id)
			return productrepo.save(product);
		return product;
	}
	
	public Product findProductById(Long id) {
		return productrepo.findProductById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product by id" + id + " was not found"));
	}
	
	public void deleteProduct(Long id) {
		productrepo.deleteProductById(id);
	}

	public List<Product> findAllProductsBySearchTerm(String searchTerm) {
		if(searchTerm != null) {
			return productrepo.findAllProductsBySearchTerm(searchTerm);
		}
		return productrepo.findAll();
	}	

	public List<Product> findAllProductsByTag(String tag) {		
		System.out.println("Inside ProductService findAllProductsByTag() method...");
		if(tag != null) {
			return productrepo.findAllProductsByTag(tag);
		}
		else
			return productrepo.findAll();
	}
	
	public List<Product> findAllProductsByCuisine(String cuisine){
		if(cuisine != null)
			return productrepo.findAllProductsByCuisine(cuisine);
		else
			return productrepo.findAll();
	}

	public List<Product> updateAllProducts(List<Product> updatedProductList) {
		return null;
	}
}
