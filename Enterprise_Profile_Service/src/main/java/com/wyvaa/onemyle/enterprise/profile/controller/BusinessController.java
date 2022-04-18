package com.wyvaa.onemyle.enterprise.profile.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyvaa.onemyle.enterprise.profile.model.Metrics;
import com.wyvaa.onemyle.enterprise.profile.model.Metrics_Campaign;
import com.wyvaa.onemyle.enterprise.profile.model.Plans;
import com.wyvaa.onemyle.enterprise.profile.service.BusinessService;

@RestController
public class BusinessController {

	private final BusinessService service;

	@Autowired
	public BusinessController(BusinessService service) {
		this.service = service;
	}

	@GetMapping("/business")
	public ResponseEntity<?> getBusiness() {
		return new ResponseEntity<>(service.getBusiness(), HttpStatus.OK);
	}
	@GetMapping("/business/{businessId}")
	public ResponseEntity<?> getBusinessById(@PathVariable String businessId) {
		try {
			return new ResponseEntity<>(service.getBusinessById(businessId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/business/{businessId}/campaigns")
	public ResponseEntity<?> getBusinessCampaigns(@PathVariable String businessId) {
		try {
			return new ResponseEntity<>(service.getBusinessCampaigns(businessId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/business/{businessId}/metrics")
	public ResponseEntity<?> getBusinessMetrics(@PathVariable String businessId) {
		try {
			
			return new ResponseEntity<>(service.getBusinessMetrics(businessId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/business/{businessId}/metrics/demographics")
	public ResponseEntity<?> getBusinessCampaignDemographyMetrics(@PathVariable String businessId) {
		try {
			return new ResponseEntity<>(service.getBusinessCampaignDemographyMetrics(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
