package com.mindtree.candyshopmanagementsystem.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Candy {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int candyId;
@Column(unique=true)
private String candyName;
private double price;
private int availableStock;
@ManyToMany(cascade=CascadeType.PERSIST,mappedBy="candies")
private Set<Shop> shops=new HashSet<Shop>();
@OneToOne(cascade=CascadeType.PERSIST)
private Type type;
public Candy() {
	super();
	// TODO Auto-generated constructor stub
}
public Candy(int candyId, String candyName, double price, int availableStock, Set<Shop> shops, Type type) {
	super();
	this.candyId = candyId;
	this.candyName = candyName;
	this.price = price;
	this.availableStock = availableStock;
	this.shops = shops;
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
public Set<Shop> getShops() {
	return shops;
}
public void setShops(Set<Shop> shops) {
	this.shops = shops;
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((candyName == null) ? 0 : candyName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Candy other = (Candy) obj;
	if (candyName == null) {
		if (other.candyName != null)
			return false;
	} else if (!candyName.equals(other.candyName))
		return false;
	return true;
}
@Override
public String toString() {
	return "Candy [candyId=" + candyId + ", candyName=" + candyName + ", price=" + price + ", availableStock="
			+ availableStock + ", shops=" + shops + ", type=" + type + "]";
}


}
