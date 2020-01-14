package com.mindtree.candyshopmanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyshopmanagementsystem.dto.ShopDto;
import com.mindtree.candyshopmanagementsystem.entity.Candy;
import com.mindtree.candyshopmanagementsystem.entity.Shop;
import com.mindtree.candyshopmanagementsystem.exception.CandyShopApplicationException;
import com.mindtree.candyshopmanagementsystem.exception.NoCandyFoundException;
import com.mindtree.candyshopmanagementsystem.exception.NoShopFoundException;
import com.mindtree.candyshopmanagementsystem.exception.SeviceException;
import com.mindtree.candyshopmanagementsystem.exception.StockUnavailableException;
import com.mindtree.candyshopmanagementsystem.repository.CandyRepository;
import com.mindtree.candyshopmanagementsystem.repository.ShopRepository;
import com.mindtree.candyshopmanagementsystem.repository.TypeRepository;
import com.mindtree.candyshopmanagementsystem.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	CandyRepository candyRepository;
	@Autowired
	ShopRepository shopRepository;
	ModelMapper modelMapper=new ModelMapper();
	@Override
	public String assignShopToCandy(Shop shop, int candyId) throws CandyShopApplicationException {
		// TODO Auto-generated method stub
	Candy  candy=candyRepository.findAll().stream().filter(i->i.getCandyId()==candyId).findAny().orElseThrow(()->new NoCandyFoundException("No Candy Found Exception"));
	shop.getCandies().add(candy);
	shopRepository.save(shop);
	//shopRepository.saveAndFlush(shop);
		return "successfully assigned";
	}
	@Override
	public Double getTotalBill(int shopId, int candyId, int quantity) throws CandyShopApplicationException {
		// TOAuto-generated method stub
       Shop shop=shopRepository.findAll().stream().filter(i->i.getShopId()==shopId).findAny().orElseThrow(()->new NoShopFoundException("No Shop Found Exception"));		
		Candy candy=shop.getCandies().stream().filter(i->i.getCandyId()==candyId).findAny().orElseThrow(()->new NoCandyFoundException("No Candy Found"));
		if(candy.getAvailableStock()<quantity)
		{
			throw new StockUnavailableException("Stock Unavailable:");
		}
		/*Double bill=quantity*candy.getPrice();
		bill=bill+bill*0.12+bill*0.02;*/
		double bill=quantity*candy.getPrice();
		bill=bill+bill*0.12+bill*0.02;
	Double bills=new Double(bill);
		/*String bills=""+bill;string leke bhi kar sakte ho uss double ko string m convert krr do
		return bills;*/
		return bills;
		
	}
	@Override
	public List<ShopDto> displayTheShopName(String candyType) throws SeviceException {
		// TODO Auto-generated method stub
		/*List<Candy> candies=candyRepository.findAll();
		Set<Shop> shops=new HashSet<Shop>();
		for (Candy candy : candies) {
			if(candy.getType().getTypeName().compareToIgnoreCase(candyType)==0) {
				shops=candy.getShops();
			}
			
		}*/
		List<Candy> candies=candyRepository.findAll();
		Set<Shop> shops=new HashSet<Shop>();
		Candy candy=candies.stream().filter(i->i.getType().getTypeName().equals(candyType)).findAny().orElseThrow(()->new NoCandyFoundException("No Candy Found Exception"));
		Set<ShopDto> shopDtos=candy.getShops().stream().map(i->convertEntityToDto(i)).collect(Collectors.toSet());
		List<ShopDto> shopDtos2=new ArrayList<ShopDto>(shopDtos);
		
		return shopDtos2;
	}
	private ShopDto convertEntityToDto(Shop i) {
		// TODO Auto-generated method stub
		return modelMapper.map(i,ShopDto.class);
	}
}
