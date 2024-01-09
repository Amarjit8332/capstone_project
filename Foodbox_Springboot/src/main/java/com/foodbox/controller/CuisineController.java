package com.foodbox.controller;

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

import com.foodbox.model.Cuisine;
import com.foodbox.model.Product;
import com.foodbox.service.CuisineService;
import com.foodbox.service.ProductService;

@RequestMapping(path="/cuisine")
@RestController
@CrossOrigin(origins="*")
public class CuisineController {
	
	@Autowired
	private CuisineService cuisineserv;
	
	@Autowired
	private ProductService productserv;
	@GetMapping(path="/all")
	public ResponseEntity<List<Cuisine>> getAllCuisines(){
		List<Cuisine> currentCuisines = cuisineserv.findAllCuisines();
		List<Product> products = productserv.findAllProducts();
		int cuisineCount=0, productCount=0;
		
		for(Cuisine c : currentCuisines) {
			System.out.println("Cuisine Id: " + c.getId() + ", Cuisine Name = " + c.getCuisineName());
			System.out.println("------------------------------------");
			
			if(c.getCuisineName().toLowerCase().equals("all")) {
				System.out.println("setting count of all products");
				productCount = products.size();
				cuisineserv.updateCuisineProductCount(c, productCount);
			}
			else {
				for (Product p : products) {
				    for (String cuisine : p.getCuisines()) {
				        if (cuisine.equals(c.getCuisineName())) {
				            System.out.println("\tProduct " + p.getId() + " - " + p.getProductName());
				            cuisineCount++;
						}
					}
				}
				cuisineserv.updateCuisineProductCount(c, cuisineCount);
				cuisineCount=0;
			}
		}
		
		return new ResponseEntity<>(currentCuisines, HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Cuisine> addCuisine(@RequestBody Cuisine cuisine){
		Cuisine newCuisine = cuisine;
		cuisineserv.addCuisine(newCuisine);
		return new ResponseEntity<>(newCuisine, HttpStatus.CREATED);
	}
	
	/* Method to update Cuisine stored in the database */
	@PutMapping("/cuisine/update/{id}")
	public ResponseEntity<Cuisine> updateCuisineProductCount(@RequestBody Cuisine cuisine, @PathVariable("id") Long id){
		System.out.println("Cuisine Passed In:\n" + cuisine.toString());
		System.out.println("Id Passed In:" + id);
		Cuisine updatedCuisine = cuisineserv.updateCuisine(cuisine);
		return new ResponseEntity<>(updatedCuisine, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/cuisine/delete/{id}")	
    public ResponseEntity<?> deletecuisine(@PathVariable("id") Long id){
		cuisineserv.deleteCuisine(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
