package com.mindtree.candyshopmanagementsystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shopId;
	@Column(unique=true)
	private String shopName;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Set<Candy> candies=new HashSet<Candy>();
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(int shopId, String shopName, Set<Candy> candies) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.candies = candies;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Set<Candy> getCandies() {
		return candies;
	}
	public void setCandies(Set<Candy> candies) {
		this.candies = candies;
	}
	
	

}
