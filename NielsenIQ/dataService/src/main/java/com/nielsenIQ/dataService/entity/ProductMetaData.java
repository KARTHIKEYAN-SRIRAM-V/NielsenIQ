package com.nielsenIQ.dataService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_meta_data")
public class ProductMetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "product_id", unique = true)
	private String productId;

	@Column(name = "category")
	private String category;

	@Column(name = "brand")
	private String brand;

}
