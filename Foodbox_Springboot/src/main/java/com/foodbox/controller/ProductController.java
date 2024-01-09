package com.foodbox.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.model.Product;
import com.foodbox.service.ProductService;

@RequestMapping(path="/products")
@RestController
@CrossOrigin(origins="*")
public class ProductController {
	@Autowired
	private ProductService productserv;
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productserv.findAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}	
		
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById (@PathVariable("id") Long id){
		Product product = productserv.findProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}	
	
	@PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
		System.out.println("Inside addProduct() in the Product Controller");
		System.out.println("Passed in Product object\n" + product.toString());
		Product newProduct = product;		
		newProduct.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
		System.out.println("newProduct:\n" + newProduct.toString());
		productserv.addProduct(newProduct);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/product/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
		System.out.println("Product Passed In:\n" + product.toString());
		System.out.println("Id Passed In:" + id);
		Product updateProduct = productserv.updateProduct(product);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
	}
	
	@PutMapping("/update/all")
	public ResponseEntity<List<Product>> updateAllProducts(List<Product> updatedProductList){		
		List<Product> newProducts = productserv.updateAllProducts(updatedProductList);
		return new ResponseEntity<>(newProducts, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/delete/{id}")	
    public void deleteProduct(@PathVariable("id") Long id){
		productserv.deleteProduct(id);
		ResponseEntity.status(HttpStatus.OK);
	}

	@GetMapping("/search/{searchTerm}")
	public ResponseEntity<List<Product>> getAllProductsBySearchTerm(@PathVariable("searchTerm") String searchTerm){
		List<Product> products = productserv.findAllProductsBySearchTerm(searchTerm);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}	

	@GetMapping("/tag/{tag}")
	public ResponseEntity<List<Product>> getAllProductsByTag(@PathVariable("tag") String tag){
		
		List<Product> products = productserv.findAllProducts();
		List<Product> filteredProducts = new ArrayList<>();		
		
		System.out.println("tag passed in: " + tag);
		
		for (Product p : products) {
	        System.out.println("p = " + p.toString());
	        if (p.getTags().contains(tag)) {
	            filteredProducts.add(p);
	        }//end if					
			}//end for	
		return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
	}
	
	@GetMapping("/cuisine/{desiredCuisine}")
	public ResponseEntity<List<Product>> getAllProductsByCuisine(@PathVariable("desiredCuisine") String desiredCuisine){
		List<Product> products = productserv.findAllProducts();
		List<Product> filteredProducts = new ArrayList<>();
		System.out.println("desiredCuisine passed in: " + desiredCuisine);
					
		for (Product p : products) {
	        System.out.println("p = " + p.toString());
	        if (p.getCuisines().contains(desiredCuisine)) {
	            filteredProducts.add(p);
	        }
	    }
				
		return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
	}	

}
