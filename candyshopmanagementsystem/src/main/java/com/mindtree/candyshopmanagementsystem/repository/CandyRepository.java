package com.mindtree.candyshopmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyshopmanagementsystem.entity.Candy;
@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer>{

}
