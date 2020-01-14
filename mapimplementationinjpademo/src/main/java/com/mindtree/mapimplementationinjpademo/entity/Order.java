package com.mindtree.mapimplementationinjpademo.entity;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
 
    @ElementCollection
    @CollectionTable(name = "order_item_mapping", 
      joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    private Map<String, Double> itemPriceMap;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, Map<String, Double> itemPriceMap) {
		super();
		this.id = id;
		this.itemPriceMap = itemPriceMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Double> getItemPriceMap() {
		return itemPriceMap;
	}

	public void setItemPriceMap(Map<String, Double> itemPriceMap) {
		this.itemPriceMap = itemPriceMap;
	}
 
    // standard getters and setters
	
    
}