package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cuisine;
@Repository
public interface CuisineRepository extends JpaRepository <Cuisine, Long>{

	void deleteCuisineById(Long id);
}
