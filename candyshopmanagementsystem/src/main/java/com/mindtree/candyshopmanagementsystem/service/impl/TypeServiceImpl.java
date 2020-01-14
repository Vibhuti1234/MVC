package com.mindtree.candyshopmanagementsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyshopmanagementsystem.repository.CandyRepository;
import com.mindtree.candyshopmanagementsystem.repository.ShopRepository;
import com.mindtree.candyshopmanagementsystem.repository.TypeRepository;
import com.mindtree.candyshopmanagementsystem.service.TypeService;
@Service
public class TypeServiceImpl implements TypeService{
@Autowired
TypeRepository typeRepository;
@Autowired
CandyRepository candyRepository;
@Autowired
ShopRepository shopRepository;
}
