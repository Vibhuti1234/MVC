package com.mindtree.candyshopmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyshopmanagementsystem.dto.CandyDto;
import com.mindtree.candyshopmanagementsystem.entity.Candy;
import com.mindtree.candyshopmanagementsystem.entity.Shop;
import com.mindtree.candyshopmanagementsystem.entity.Type;
import com.mindtree.candyshopmanagementsystem.exception.CandyShopApplicationException;
import com.mindtree.candyshopmanagementsystem.exception.NoCandyFoundException;
import com.mindtree.candyshopmanagementsystem.exception.NoShopFoundException;
import com.mindtree.candyshopmanagementsystem.exception.SeviceException;
import com.mindtree.candyshopmanagementsystem.repository.CandyRepository;
import com.mindtree.candyshopmanagementsystem.repository.ShopRepository;
import com.mindtree.candyshopmanagementsystem.repository.TypeRepository;
import com.mindtree.candyshopmanagementsystem.service.CandyService;
@Service
public class CandyServiceImpl implements CandyService{
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	CandyRepository candyRepository;
	@Autowired
	ShopRepository shopRepository;
	ModelMapper modelMapper=new ModelMapper();
	@Override
	public String addCandy(Candy candy) {
		// TODO Auto-generated method stub
		candyRepository.save(candy);
		return "successfully inserted";
	}
	@Override
	public String addTypeToCandy(Type type, int candyId) throws CandyShopApplicationException {
		// TODO Auto-generated method stub
		Candy candy=candyRepository.findAll().stream().filter(i->i.getCandyId()==candyId).findAny().orElseThrow(()->new NoCandyFoundException("No Such Candy Found:"));
		candy.setType(type);
		candyRepository.saveAndFlush(candy);
		return "successfull assigned";
	}
	@Override
	public String assignCandyToShop(Candy candy, int shopId) throws SeviceException {
		// TODO Auto-generated method stub
		Shop shop=shopRepository.findAll().stream().filter(i->i.getShopId()==shopId).findAny().orElseThrow(()->new NoShopFoundException("No Such Shop Found "));
		
		/*candy.getShops().add(shop);
		candyRepository.save(candy);*/
		System.out.println(candy.toString());
		shop.getCandies().add(candy);
		candyRepository.save(candy);
		shopRepository.save(shop);
		
		return "successfully assigned";
	}
	@Override
	public List<CandyDto> getAllCandiesByShop(int shopId) throws SeviceException {
		// TODO Auto-generated method stub
		Shop shop=shopRepository.findAll().stream().filter(i->i.getShopId()==shopId).findAny().orElseThrow(()->new NoShopFoundException("No Shop Found"));
		List<CandyDto> candyDtos=shop.getCandies().stream().map(i->convertEntityToDto(i)).collect(Collectors.toList());
		return candyDtos;
	}
	private CandyDto convertEntityToDto(Candy i) {
		// TODO Auto-generated method stub
		return modelMapper.map(i, CandyDto.class);
	}
}
