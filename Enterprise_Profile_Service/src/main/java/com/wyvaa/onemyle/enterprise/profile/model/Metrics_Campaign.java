package com.wyvaa.onemyle.enterprise.profile.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metrics_Campaign {

	private int posts_count;
	private int views_count;
	private int duration;
	 Plans plan;
	private Demographics1[] demographics;
	
	
	
	public Plans getPlan() {
		return plan;
	}
	public void setPlan(Plans plan) {
		this.plan = plan;
	}
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Demographics1[] getDemographics() {
		return demographics;
	}
	public void setDemographics(Demographics1[] demographics) {
		this.demographics = demographics;
	}
	
	
}
