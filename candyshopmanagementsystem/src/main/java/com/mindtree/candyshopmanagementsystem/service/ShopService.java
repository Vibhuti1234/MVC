package com.mindtree.candyshopmanagementsystem.service;

import java.util.List;

import com.mindtree.candyshopmanagementsystem.dto.ShopDto;
import com.mindtree.candyshopmanagementsystem.entity.Shop;
import com.mindtree.candyshopmanagementsystem.exception.CandyShopApplicationException;
import com.mindtree.candyshopmanagementsystem.exception.SeviceException;

public interface ShopService {

	String assignShopToCandy(Shop shop, int candyId) throws CandyShopApplicationException;

   Double getTotalBill(int shopId, int candyId, int quantity) throws CandyShopApplicationException;

List<ShopDto> displayTheShopName(String candyType) throws SeviceException;

}
