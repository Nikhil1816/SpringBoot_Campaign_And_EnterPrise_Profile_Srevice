package com.wyvaa.onemyle.campaign.metric.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wyvaa.onemyle.campaign.metric.exception.RecordNotFoundException;
import com.wyvaa.onemyle.campaign.metric.model.CampaignMetrics;
import com.wyvaa.onemyle.campaign.metric.repository.CampaignRepositoryRepository;
import com.wyvaa.onemyle.campaign.metric.service.CampaignMetricService;

@RestController
public class CampaignMetricsController {

	@Autowired
	private CampaignMetricService service;
	@Autowired
    private CampaignRepositoryRepository campaignRepositoryRepository;
	@PostMapping("/campaigns/{campaignId}/metrics")
	public ResponseEntity<CampaignMetrics> addMetricsCampaign(@PathVariable(required=false,value="campaignId") String campaignId,
			@RequestBody CampaignMetrics metricsCampaign) {
		try {
			metricsCampaign.setCampaignId(campaignId);
			CampaignMetrics exist=campaignRepositoryRepository.findByCampaignId(campaignId);
			metricsCampaign.setCreatedAt( new Date(System.currentTimeMillis()));
			metricsCampaign.setUpdatedAt( new Date(System.currentTimeMillis()));
			if(exist==null) {
			return new ResponseEntity<CampaignMetrics>(service.saveMetricsCampaign(metricsCampaign),
					HttpStatus.CREATED);
			}else {
				return ResponseEntity.ok(exist);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/campaigns/{campaignId}/metrics")
	public ResponseEntity<CampaignMetrics> getMetricsCampaign(@PathVariable("campaignId") String campaignId) throws RecordNotFoundException {
		CampaignMetrics exist=campaignRepositoryRepository.findByCampaignId(campaignId);
		
		if(exist!=null) {
		
			return  ResponseEntity.ok(exist);
		
		}else {
			throw new RecordNotFoundException("CampainId record not found");
		}
		
		
	}
	

	@PutMapping("/campaigns/{campaignId}/metrics")
	public ResponseEntity<CampaignMetrics> updateMetricsCampaign(@PathVariable("campaignId") String campaignId,
			@RequestBody CampaignMetrics campaignMetrics) throws RecordNotFoundException {
		CampaignMetrics exist=campaignRepositoryRepository.findByCampaignId(campaignId);
		 campaignMetrics.setUpdatedAt( new Date(System.currentTimeMillis()));
		if(exist!=null) {
		return new ResponseEntity<CampaignMetrics>(service.updateMetricsCampaign(campaignMetrics, campaignId),
				HttpStatus.OK);
		}else {
			throw new RecordNotFoundException("CampainId record not found");
		}
		}

}
