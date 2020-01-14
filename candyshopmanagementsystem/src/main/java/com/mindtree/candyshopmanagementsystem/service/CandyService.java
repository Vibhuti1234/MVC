package com.mindtree.candyshopmanagementsystem.service;

import java.util.List;

import com.mindtree.candyshopmanagementsystem.dto.CandyDto;
import com.mindtree.candyshopmanagementsystem.entity.Candy;
import com.mindtree.candyshopmanagementsystem.entity.Type;
import com.mindtree.candyshopmanagementsystem.exception.CandyShopApplicationException;
import com.mindtree.candyshopmanagementsystem.exception.SeviceException;

public interface CandyService {

	String addCandy(Candy candy);

	String addTypeToCandy(Type type, int candyId) throws CandyShopApplicationException;

	String assignCandyToShop(Candy candy, int shopId) throws SeviceException;

	List<CandyDto> getAllCandiesByShop(int shopId) throws SeviceException;

}
