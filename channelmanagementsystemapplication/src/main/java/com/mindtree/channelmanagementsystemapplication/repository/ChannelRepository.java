package com.mindtree.channelmanagementsystemapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelmanagementsystemapplication.entity.Channel;
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer>{

}
