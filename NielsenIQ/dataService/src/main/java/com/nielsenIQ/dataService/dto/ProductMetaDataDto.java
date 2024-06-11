package com.nielsenIQ.dataService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "id" })
public class ProductMetaDataDto {

	private String productId;
	private String category;
	private String brand;

}
