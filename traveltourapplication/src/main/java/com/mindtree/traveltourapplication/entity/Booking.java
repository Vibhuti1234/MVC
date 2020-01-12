package com.mindtree.traveltourapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private String source;
	private String destination;
	private String dateOfJourney;
	private int distance;
	private double bookingPrice;
	private String foodPreference;
	private String travellingWith;
	@ManyToOne
	private User user=new User();
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Booking(int bookingId, String source, String destination, String dateOfJourney, int distance,
			double bookingPrice, String foodPreference, String travellingWith, User user) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
		this.distance = distance;
		this.bookingPrice = bookingPrice;
		this.foodPreference = foodPreference;
		this.travellingWith = travellingWith;
		this.user = user;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getFoodPreference() {
		return foodPreference;
	}
	public void setFoodPreference(String foodPreference) {
		this.foodPreference = foodPreference;
	}
	public String getTravellingWith() {
		return travellingWith;
	}
	public void setTravellingWith(String travellingWith) {
		this.travellingWith = travellingWith;
	}

	public double getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
}
