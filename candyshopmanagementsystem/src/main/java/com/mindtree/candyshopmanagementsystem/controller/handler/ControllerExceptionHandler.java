package com.mindtree.candyshopmanagementsystem.controller.handler;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.candyshopmanagementsystem.controller.CandyShopController;
import com.mindtree.candyshopmanagementsystem.dto.ExceptionDto;

@RestControllerAdvice(assignableTypes= {CandyShopController.class})
public class ControllerExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionDto> serviceExceptionHandler(Exception e, Throwable cause){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}
}
