package com.mindtree.mapimplementationinjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.mapimplementationinjpademo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	

}
