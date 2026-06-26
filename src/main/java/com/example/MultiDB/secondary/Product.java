package com.example.MultiDB.secondary;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE)
	private Long productId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "description")
	private String productDescription;
}
