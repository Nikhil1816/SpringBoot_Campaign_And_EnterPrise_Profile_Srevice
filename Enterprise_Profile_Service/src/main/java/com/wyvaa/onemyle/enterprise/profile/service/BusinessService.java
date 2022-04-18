package com.wyvaa.onemyle.enterprise.profile.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.wyvaa.onemyle.enterprise.profile.model.Business;
import com.wyvaa.onemyle.enterprise.profile.model.Campaign;
import com.wyvaa.onemyle.enterprise.profile.model.Metrics;
import com.wyvaa.onemyle.enterprise.profile.model.Metrics_Campaign;

@Service
public class BusinessService {
	private final RestTemplate restTemplate;

	@Autowired
	public BusinessService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
	}

	public List<?> getBusiness() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Business> entity = new HttpEntity<Business>(headers);
		ResponseEntity<List> business = restTemplate.exchange("https://staging.onemyle.com/api/enterprise/business",
				HttpMethod.GET, entity, List.class);
		return business.getBody();
	}

	public Business getBusinessById(String businessId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Business> entity = new HttpEntity<Business>(headers);
		ResponseEntity<Business> business = restTemplate.exchange(
				"https://staging.onemyle.com/api/enterprise/business/" + businessId, HttpMethod.GET, entity,
				Business.class);
		return business.getBody();
	}

	public Campaign[] getBusinessCampaigns(String businessId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Campaign> entity = new HttpEntity<Campaign>(headers);
		ResponseEntity<Campaign[]> business = restTemplate.exchange(
				"https://2910d81c-e83f-4290-9e11-e94d7ea4fcd4.mock.pstmn.io/enterprise/business/id/campaigns",
				HttpMethod.GET, entity, Campaign[].class);
		return business.getBody();
	}

	public Metrics getBusinessMetrics(String businessId) {
		Campaign[] campaigns = getBusinessCampaigns(businessId);
		Metrics businessMetrics = new Metrics();
		Metrics_Campaign campaignMetrics = new Metrics_Campaign();
		ObjectMapper objectMapper = new ObjectMapper();
		businessMetrics.setCampaigns_count(campaigns.length);
		int sum = campaignMetrics.getPosts_count();
		int views = campaignMetrics.getViews_count();
		for (int i = 0; i < campaigns.length; i++) {
			try {
				Campaign campaign = campaigns[i];
				String campaignId = campaign.getCampaignId();

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<Metrics> entity = new HttpEntity<Metrics>(headers);
				ResponseEntity<Metrics_Campaign> business = restTemplate.exchange(
						"http://localhost:8080/campaigns/" + campaignId + "/metrics", HttpMethod.GET, entity,
						Metrics_Campaign.class);
				sum += business.getBody().getPosts_count();
                views+=business.getBody().getViews_count();
				System.out.println(business.getBody());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		businessMetrics.setViews_count(views);
		businessMetrics.setPosts_count(sum);
		return businessMetrics;

	}

	public Metrics_Campaign getBusinessCampaignDemographyMetrics() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Metrics_Campaign> entity = new HttpEntity<Metrics_Campaign>(headers);
		ResponseEntity<Metrics_Campaign> business = restTemplate.exchange(
				"https://2910d81c-e83f-4290-9e11-e94d7ea4fcd4.mock.pstmn.io/enterprise/business/id/metrics?campaignId=id",
				HttpMethod.GET, entity, Metrics_Campaign.class);
		return business.getBody();
	}
}
