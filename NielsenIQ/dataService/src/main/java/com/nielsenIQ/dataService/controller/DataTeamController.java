package com.nielsenIQ.dataService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.nielsenIQ.dataService.dto.ProductMetaDataDto;
import com.nielsenIQ.dataService.dto.Response;
import com.nielsenIQ.dataService.service.DataTeamService;

@RestController
@RequestMapping(value = "/save/data")
public class DataTeamController {

	@Autowired
	private DataTeamService dataTeamService;

	@PostMapping(value = "/meta")
	public ResponseEntity<?> saveMeta(@RequestBody ProductMetaDataDto productMetaDataDto) {

		Response response = dataTeamService.saveMetaData(productMetaDataDto);

		if (response.getStatusCode() == 200) {
			return ResponseEntity.ok(response);
		}

		else {
			return ResponseEntity.badRequest().body(response);
		}

	}

	@PostMapping(value = "/personalized")
	public ResponseEntity<?> savePersonalized(@RequestBody JsonNode jNode) {

		Response response = dataTeamService.savePersonalizedData(jNode);

		if (response.getStatusCode() == 200) {
			return ResponseEntity.ok(response);
		}

		else {
			return ResponseEntity.badRequest().body(response);
		}

	}

}
