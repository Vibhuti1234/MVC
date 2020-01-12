package com.mindtree.traveltourapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.traveltourapplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
