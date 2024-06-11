package com.nielsenIQ.dataService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "id" })
public class ProductDto {

	@JsonProperty("productId")
	private String productId;

	@JsonProperty("relevencyScore")
	private Double relevencyScore;

}
