package com.mindtree.candyshopmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyshopmanagementsystem.entity.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>{

}
