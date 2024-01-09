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
@Table(name="tags")
public class Tag {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tagid")
	private Long id;
	@Column(name="tagname")
	private String tagName;
	@Column(name="productcount", columnDefinition = "int default 0")		
	private int productCount = 0;

}
