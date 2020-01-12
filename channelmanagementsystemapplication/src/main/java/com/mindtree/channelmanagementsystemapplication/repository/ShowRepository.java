package com.mindtree.channelmanagementsystemapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelmanagementsystemapplication.entity.Show;
@Repository
public interface ShowRepository  extends JpaRepository<Show, Integer>{

}
