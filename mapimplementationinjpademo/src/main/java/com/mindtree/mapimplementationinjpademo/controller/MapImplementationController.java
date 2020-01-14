package com.mindtree.mapimplementationinjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.mapimplementationinjpademo.entity.Order;
import com.mindtree.mapimplementationinjpademo.service.OrderService;

@RestController
public class MapImplementationController {
	@Autowired
	OrderService orderService;
	@PostMapping("/addOrder")
	public Object addOrder(@RequestBody Order order)
	{
		return orderService.addOrder(order);
	}

}
