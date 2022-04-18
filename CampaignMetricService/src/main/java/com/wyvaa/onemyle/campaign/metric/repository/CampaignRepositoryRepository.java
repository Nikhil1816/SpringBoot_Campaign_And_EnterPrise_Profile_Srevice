package com.wyvaa.onemyle.campaign.metric.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wyvaa.onemyle.campaign.metric.model.CampaignMetrics;

public interface CampaignRepositoryRepository extends MongoRepository<CampaignMetrics,Integer> {

	

	CampaignMetrics findByCampaignId(String campaignId);

}
