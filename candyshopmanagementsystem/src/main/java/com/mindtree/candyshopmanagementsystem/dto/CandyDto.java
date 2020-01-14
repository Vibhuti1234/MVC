package com.mindtree.candyshopmanagementsystem.dto;

public class CandyDto {
	private int candyId;

	private String candyName;
	private double price;
	private int availableStock;
	private TypeDto type;
	public CandyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CandyDto(int candyId, String candyName, double price, int availableStock, TypeDto type) {
		super();
		this.candyId = candyId;
		this.candyName = candyName;
		this.price = price;
		this.availableStock = availableStock;
		this.type = type;
	}

	public int getCandyId() {
		return candyId;
	}
	public void setCandyId(int candyId) {
		this.candyId = candyId;
	}
	public String getCandyName() {
		return candyName;
	}
	public void setCandyName(String candyName) {
		this.candyName = candyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	public TypeDto getType() {
		return type;
	}
	public void setType(TypeDto type) {
		this.type = type;
	}

	
	
}
