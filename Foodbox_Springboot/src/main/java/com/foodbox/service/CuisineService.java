package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.Cuisine;
import com.foodbox.repository.CuisineRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuisineService {
	@Autowired
	private CuisineRepository cuisinerepo;
	
	public List<Cuisine> findAllCuisines(){
		return cuisinerepo.findAll();
		
	}
	public Cuisine addCuisine(Cuisine cuisine) {
		return cuisinerepo.save(cuisine);
	}
	
	public Cuisine updateCuisine(Cuisine cuisine) {
		return cuisinerepo.save(cuisine);
	}
	
	public Cuisine updateCuisine(Cuisine cuisine, Long id) {
		if(cuisine.getId() == id) {
			return cuisinerepo.save(cuisine);
		}
		return null;
	}
	
	public void updateCuisineProductCount(Cuisine cuisine, int newProductCount) {
		cuisine.setProductCount(newProductCount);
	}
	
	public void deleteCuisine(Long id) {
		cuisinerepo.deleteCuisineById(id);
	}

}
