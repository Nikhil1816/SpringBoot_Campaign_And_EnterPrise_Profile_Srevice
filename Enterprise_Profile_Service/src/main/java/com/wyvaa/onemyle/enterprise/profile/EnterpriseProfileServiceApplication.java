package com.wyvaa.onemyle.enterprise.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.wyvaa.onemyle.enterprise.profile.service.BusinessService;

@SpringBootApplication
public class EnterpriseProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseProfileServiceApplication.class, args);
		
	}

}
