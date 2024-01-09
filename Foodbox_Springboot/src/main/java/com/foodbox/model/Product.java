package com.foodbox.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private Long id;
	
	@Column(name="productImageUrl")
	private String productImageUrl;
	
	@Column(name="productName")
    private String productName;
	
	@Column(name="price")
    private BigDecimal price;
	
	@Column(name="calories")
    private int calories;
	
	@Column(name="rating")
    private float rating;
	
	@Column(name="numOfReviews")
    private float numOfReviews;
    
	@Lob
    @Column(name="description")
    private String description;
    
	
    
	@Column(name="dateCreated")
    private Timestamp dateCreated;
	 @Column(name = "tags")
	    @ElementCollection
	    public Set<String> tags;

	    @Column(name = "cuisines")
	    @ElementCollection
	    public Set<String> cuisines;

}
