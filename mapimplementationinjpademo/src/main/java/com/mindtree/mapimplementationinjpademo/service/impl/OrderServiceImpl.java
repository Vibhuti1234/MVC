package com.mindtree.mapimplementationinjpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.mapimplementationinjpademo.entity.Order;
import com.mindtree.mapimplementationinjpademo.repository.OrderRepository;
import com.mindtree.mapimplementationinjpademo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Object addOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
		return "success";
	}

}
