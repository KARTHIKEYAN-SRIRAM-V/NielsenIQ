package com.nielsenIQ.dataService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielsenIQ.dataService.dto.ProductMetaDataDto;
import com.nielsenIQ.dataService.entity.Product;
import com.nielsenIQ.dataService.entity.ProductMetaData;
import com.nielsenIQ.dataService.entity.Shopper;
import com.nielsenIQ.dataService.repository.ProductMetaDataRepository;
import com.nielsenIQ.dataService.repository.ShopperRepository;

@Service
public class EcomService {

	@Autowired
	private ShopperRepository shopperRepository;

	@Autowired
	private ProductMetaDataRepository productMetaDataRepository;

	// To get Shopper data based on Shopper id
	public List<ProductMetaDataDto> getProductById(String id) {

		ObjectMapper mapper = new ObjectMapper();

		Shopper shopper = shopperRepository.findByShopperId(id);
		List<ProductMetaDataDto> productMetaDataDto = new ArrayList<ProductMetaDataDto>();

		for (Product pr : shopper.getProduct())
			productMetaDataDto.add(mapper.convertValue(productMetaDataRepository.findByProductId(pr.getProductId()),
					ProductMetaDataDto.class));

		return productMetaDataDto;
	}

	// To get Product data based on Category
	public List<ProductMetaDataDto> getProductByCategory(String category, int pageNo, int size) {

		ObjectMapper mapper = new ObjectMapper();
		PageRequest pageRequest = PageRequest.of(pageNo, size);

		Optional<List<ProductMetaData>> productMetaData = productMetaDataRepository.findByCategory(category,
				pageRequest);
		List<ProductMetaDataDto> productMetaDataDto = new ArrayList<ProductMetaDataDto>();

		if (productMetaData.isPresent())
			for (ProductMetaData pmd : productMetaData.get())
				productMetaDataDto.add(mapper.convertValue(pmd, ProductMetaDataDto.class));

		return productMetaDataDto;
	}

	// To get Product data based on Category
	public List<ProductMetaDataDto> getProductByBrand(String brand, int pageNo, int size) {

		ObjectMapper mapper = new ObjectMapper();
		PageRequest pageRequest = PageRequest.of(pageNo, size);

		Optional<List<ProductMetaData>> productMetaData = productMetaDataRepository.findByBrand(brand, pageRequest);
		List<ProductMetaDataDto> productMetaDataDto = new ArrayList<ProductMetaDataDto>();

		if (productMetaData.isPresent())
			for (ProductMetaData pmd : productMetaData.get())
				productMetaDataDto.add(mapper.convertValue(pmd, ProductMetaDataDto.class));

		return productMetaDataDto;
	}

}
