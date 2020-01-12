package com.mindtree.channelmanagementsystemapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.channelmanagementsystemapplication.entity.ChannelGroup;
@Repository
public interface ChannelGroupRepository extends JpaRepository<ChannelGroup, Integer>{

}
