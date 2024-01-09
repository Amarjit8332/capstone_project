package com.foodbox.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Table(name="cuisines")
public class Cuisine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cuisineid")
	private Long id;
	@Column(name="cuisinename")
	private String cuisineName;
	@Column(name="productcount", columnDefinition="int default 0")
	private int productCount = 0;

}
