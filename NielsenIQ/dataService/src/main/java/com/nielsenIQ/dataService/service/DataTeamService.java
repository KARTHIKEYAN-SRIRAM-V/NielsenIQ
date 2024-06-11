package com.nielsenIQ.dataService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nielsenIQ.dataService.dto.ProductMetaDataDto;
import com.nielsenIQ.dataService.dto.Response;
import com.nielsenIQ.dataService.dto.ShopperDto;
import com.nielsenIQ.dataService.entity.ProductMetaData;
import com.nielsenIQ.dataService.entity.Shopper;
import com.nielsenIQ.dataService.repository.ProductMetaDataRepository;
import com.nielsenIQ.dataService.repository.ShopperRepository;

@Service
public class DataTeamService {

	@Autowired
	private ShopperRepository shopperRepository;

	@Autowired
	private ProductMetaDataRepository productMetaDataRepository;

	// To save the Meta Data received from Data Team
	public Response saveMetaData(ProductMetaDataDto productMetaDataDto) {

		Response response = new Response();

		ObjectMapper mapper = new ObjectMapper();
		ProductMetaData productMetaData = mapper.convertValue(productMetaDataDto, ProductMetaData.class);

		try {
			productMetaDataRepository.save(productMetaData);
			response.setMessage("Metadata saved successfully");
			response.setStatusCode(200);
			return response;
		} catch (Exception e) {
			response.setMessage("Metadata saving failed");
			response.setStatusCode(400);
			return response;
		}

	}

	// To save the Personalized Data received from Data Team
	public Response savePersonalizedData(ShopperDto obj) {

		Response response = new Response();

		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Shopper shopper = mapper.convertValue(obj, Shopper.class);

		try {
			shopperRepository.save(shopper);
			response.setMessage("Personalized Data saved successfully");
			response.setStatusCode(200);
			return response;
		} catch (Exception e) {
			response.setMessage("Personalized Data saving failed");
			response.setStatusCode(400);
			return response;
		}

	}

}
