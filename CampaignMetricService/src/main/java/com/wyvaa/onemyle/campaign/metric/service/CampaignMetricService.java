package com.wyvaa.onemyle.campaign.metric.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wyvaa.onemyle.campaign.metric.exception.RecordNotFoundException;
import com.wyvaa.onemyle.campaign.metric.model.CampaignMetrics;
import com.wyvaa.onemyle.campaign.metric.repository.CampaignRepositoryRepository;

@Service
public class CampaignMetricService {

	@Autowired
	private CampaignRepositoryRepository repository;
	
	public CampaignMetrics saveMetricsCampaign(CampaignMetrics campaignMetrics) {
	
		campaignMetrics.setCreatedAt( new Date(System.currentTimeMillis()));
		 campaignMetrics.setUpdatedAt( new Date(System.currentTimeMillis()));
		return repository.save(campaignMetrics);
		
	}
	
	public List<CampaignMetrics> getMetricsCampaign(){
		return repository.findAll();
	}
	public CampaignMetrics getMetricsCampaignByCampaignId(String campaignId) throws RecordNotFoundException{
		return  repository.findByCampaignId(campaignId);
		
	}
	public CampaignMetrics updateMetricsCampaign(CampaignMetrics campaignMetrics,String campaignId) {
		CampaignMetrics exist=repository.findByCampaignId(campaignMetrics.getCampaignId());
		campaignMetrics.setUpdatedAt( new Date(System.currentTimeMillis()));
		exist.setViews_count(campaignMetrics.getViews_count());
		exist.setPosts_count(campaignMetrics.getPosts_count());
		exist.setDuration(campaignMetrics.getDuration());
		return repository.save(exist);
		
		}
}
