package com.nielsenIQ.dataService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nielsenIQ.dataService.dto.ProductMetaDataDto;
import com.nielsenIQ.dataService.dto.Response;
import com.nielsenIQ.dataService.service.EcomService;

@RestController
@RequestMapping(value = "/product/details")
public class EcomServerController {

	@Autowired
	private EcomService ecomService;

	@GetMapping(value = "/byId/{id}")
	public ResponseEntity<?> getProductDetailsById(@PathVariable String id) {

		List<ProductMetaDataDto> productMetaDataDto = ecomService.getProductById(id);
		Response response = new Response();

		if (productMetaDataDto != null) {
			return ResponseEntity.ok(productMetaDataDto);
		}

		else {
			response.setMessage("Data not found for the id: " + id);
			response.setStatusCode(404);
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
		}

	}

	@GetMapping(value = "/byCategory/{category}/{pageNo}/{size}")
	public ResponseEntity<?> getProductDetailsByCategory(@PathVariable String category, @PathVariable int pageNo,
			@PathVariable int size) {

		List<ProductMetaDataDto> productMetaDataDto = ecomService.getProductByCategory(category, pageNo, size);
		Response response = new Response();

		if (productMetaDataDto != null) {
			return ResponseEntity.ok(productMetaDataDto);
		}

		else {
			response.setMessage("Data not found for the category: " + category);
			response.setStatusCode(404);
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
		}

	}

	@GetMapping(value = "/byBrand/{brand}/{pageNo}/{size}")
	public ResponseEntity<?> getProductDetailsByBrand(@PathVariable String brand, @PathVariable int pageNo,
			@PathVariable int size) {

		List<ProductMetaDataDto> productMetaDataDto = ecomService.getProductByBrand(brand, pageNo, size);
		Response response = new Response();

		if (productMetaDataDto != null) {
			return ResponseEntity.ok(productMetaDataDto);
		}

		else {
			response.setMessage("Data not found for the brand: " + brand);
			response.setStatusCode(404);
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
		}

	}

}
