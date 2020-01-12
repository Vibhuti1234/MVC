package com.mindtree.traveltourapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	@Id
	private long phoneNumber;
	private String userName;
	private int age;
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	//@JoinColumn(name="phoneNumber")
	private Set<Booking> bookings=new HashSet<Booking>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long phoneNumber, String userName, int age, Set<Booking> bookings) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.age = age;
		this.bookings = bookings;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
	

}
