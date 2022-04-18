package com.wyvaa.onemyle.campaign.metric.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecordNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public RecordNotFoundException() {
		
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}