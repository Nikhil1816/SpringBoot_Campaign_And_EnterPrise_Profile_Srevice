package com.wyvaa.onemyle.campaign.metric.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(RecordNotFoundException exception, WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(0), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(0), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
