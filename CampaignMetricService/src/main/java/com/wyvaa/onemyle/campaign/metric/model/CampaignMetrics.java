package com.wyvaa.onemyle.campaign.metric.model;

import java.util.Date;
import java.util.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CampaignMetrics")
public class CampaignMetrics {

	@Id
	private String campaignMetricsId;
	private long posts_count;
	private long views_count;
	private long duration;
	Plans plan;
	private String campaignId;
	private String owner;
	private String campaignType;
	private Date createdAt;
	private Date updatedAt;
	private Demographics1[] demographics= {};
	private String businessId;
	
	
	
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	
	
	
	public Plans getPlan() {
		return plan;
	}
	public void setPlan(Plans plan) {
		this.plan = plan;
	}
	public String getCampaignType() {
		return campaignType;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
	public String getCampaignMetricsId() {
		return campaignMetricsId;
	}
	public void setCampaignMetricsId(String campaignMetricsId) {
		this.campaignMetricsId = campaignMetricsId;
	}
	public long getPosts_count() {
		return posts_count;
	}
	public void setPosts_count(long posts_count) {
		this.posts_count = posts_count;
	}
	public long getViews_count() {
		return views_count;
	}
	public void setViews_count(long views_count) {
		this.views_count = views_count;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Demographics1[] getDemographics() {
		return demographics;
	}
	public void setDemographics(Demographics1[] demographics) {
		this.demographics = demographics;
	}
	
	
}
