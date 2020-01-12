package com.mindtree.channelmanagementsystemapplication.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.channelmanagementsystemapplication.controller.ChannelController;
import com.mindtree.channelmanagementsystemapplication.exception.NoSuchChannelFoundException;
import com.mindtree.channelmanagementsystemapplication.exception.NoSuchChannelGroupFoundException;

@RestControllerAdvice(assignableTypes = { ChannelController.class })
public class AppExceptionHandler {
	
	@ExceptionHandler(NoSuchChannelFoundException.class)
	public ResponseEntity<String> serviceExceptionHandler(NoSuchChannelFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	

	@ExceptionHandler(NoSuchChannelGroupFoundException.class)
	public ResponseEntity<String> serviceExceptionHandler(NoSuchChannelGroupFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	

}
