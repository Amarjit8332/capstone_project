package com.foodbox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
Optional<Product> findProductById(Long id);
	
	void deleteProductById(Long id);
	
	@Query("SELECT p from Product p WHERE p.productName LIKE %?1%")
	public List<Product> findAllProductsBySearchTerm(String searchTerm);
	
	@Query("SELECT p FROM Product p WHERE :tag MEMBER OF p.tags")
	public List<Product> findAllProductsByTag(@Param("tag") String tag);

	
	@Query("SELECT p from Product p WHERE p.cuisines LIKE %?1%")
	public List<Product> findAllProductsByCuisine(String cuisine);
}
