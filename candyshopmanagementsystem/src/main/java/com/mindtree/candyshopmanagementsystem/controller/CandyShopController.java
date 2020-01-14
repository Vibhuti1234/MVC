package com.mindtree.candyshopmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.candyshopmanagementsystem.dto.CandyDto;
import com.mindtree.candyshopmanagementsystem.dto.ShopDto;
import com.mindtree.candyshopmanagementsystem.entity.Candy;
import com.mindtree.candyshopmanagementsystem.entity.Shop;
import com.mindtree.candyshopmanagementsystem.entity.Type;
import com.mindtree.candyshopmanagementsystem.exception.CandyShopApplicationException;
import com.mindtree.candyshopmanagementsystem.exception.SeviceException;
import com.mindtree.candyshopmanagementsystem.service.CandyService;
import com.mindtree.candyshopmanagementsystem.service.ShopService;
import com.mindtree.candyshopmanagementsystem.service.TypeService;

@RestController
public class CandyShopController {
	@Autowired
	CandyService candyService;
	@Autowired
	ShopService shopService;
	@Autowired
	TypeService typeService;
	/*@PostMapping(value="/user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) throws ServiceException {
		UserDto savedUserDto = userService.addUser(user);
		return ResponseEntity.status(
				
				HttpStatus.OK).body(savedUserDto);
	}*/
	@PostMapping(value="/addCandy")
	public ResponseEntity<String> addCandy(@RequestBody Candy candy)
	{
		String messege=candyService.addCandy(candy);
		return ResponseEntity.status(HttpStatus.OK).body(messege);
	}
	@PostMapping(value="/addTypeToCandy/{candyId}")
	public ResponseEntity<String> addTypeToCandy(@RequestBody Type type,@PathVariable int candyId) throws CandyShopApplicationException
	{
		String message =candyService.addTypeToCandy(type,candyId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
    @PostMapping(value="/assignShopToCandy/{candyId}")
    public ResponseEntity<String> assignShopToCandy(@RequestBody Shop shop,@PathVariable int candyId) throws CandyShopApplicationException
    {
    	String message=shopService.assignShopToCandy(shop,candyId);
    	return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    /*@GetMapping(value = "room")
	public ResponseEntity<RoomDto> getRoomById(@RequestParam("id") Long roomId) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomById(roomId));
	}*/
    @GetMapping(value="/getTotalBill/{shopId}/{candyId}/{quantity}")
    public ResponseEntity<Double> getTotalBill(@PathVariable int shopId,@PathVariable int candyId,@PathVariable int quantity) throws CandyShopApplicationException
    {Double bill=shopService.getTotalBill(shopId,candyId,quantity);
    	return ResponseEntity.status(HttpStatus.OK).body(bill);
    }
    @PostMapping(value="/assignCandyToShop/{shopId}")
    public ResponseEntity<String> assignCandyToShop(@RequestBody Candy candy,@PathVariable int shopId) throws SeviceException
    {
    	String message =candyService.assignCandyToShop(candy,shopId);
    	return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @GetMapping(value="/getAllCandiesByShop/{shopId}")
    public ResponseEntity<List<CandyDto>> getAllCandiesByShop(@PathVariable int shopId) throws SeviceException
    {
    	List<CandyDto> candyDtos=candyService.getAllCandiesByShop(shopId);
    	return ResponseEntity.status(HttpStatus.OK).body(candyDtos);

    }
    @GetMapping(value="/displayTheShopName/{candyType}")
    public ResponseEntity<List<ShopDto>> displayTheShopName(@PathVariable String candyType) throws SeviceException
    {
    	List<ShopDto> shopDtos=shopService.displayTheShopName(candyType);
    	return ResponseEntity.status(HttpStatus.OK).body(shopDtos);

    }
    
}
