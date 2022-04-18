package com.wyvaa.onemyle.enterprise.profile.model;

public class Metrics {

	
	private int posts_count;
	private int views_count;
	private int campaigns_count;

	private Demographics[] demographics;
	
	
	public int getPosts_count() {
		return posts_count;
	}
	public void setPosts_count(int posts_count) {
		this.posts_count = posts_count;
	}
	public int getViews_count() {
		return views_count;
	}
	public void setViews_count(int views_count) {
		this.views_count = views_count;
	}
	public int getCampaigns_count() {
		return campaigns_count;
	}
	public void setCampaigns_count(int campaigns_count) {
		this.campaigns_count = campaigns_count;
	}
	public Demographics[] getDemographics() {
		return demographics;
	}
	public void setDemographics(Demographics[] demographics) {
		this.demographics = demographics;
	}
	
	
}
