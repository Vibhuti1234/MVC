package com.mindtree.candyshopmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyshopmanagementsystem.entity.Type;
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer>{

}
