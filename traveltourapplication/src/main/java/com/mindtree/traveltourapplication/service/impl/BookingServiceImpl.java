package com.mindtree.traveltourapplication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.traveltourapplication.entity.Booking;
import com.mindtree.traveltourapplication.entity.User;
import com.mindtree.traveltourapplication.exception.InvalidDateOfJourneyException;
import com.mindtree.traveltourapplication.exception.NoUserFoundException;
import com.mindtree.traveltourapplication.exception.ServiceException;
import com.mindtree.traveltourapplication.repository.BookingRepository;
import com.mindtree.traveltourapplication.repository.UserRepository;
import com.mindtree.traveltourapplication.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService{
@Autowired
BookingRepository bookingRepository;
@Autowired
UserRepository userRepository;
@Override
public void addBookingToUser(Booking booking, long phoneNumber) throws ServiceException {
	// TODO Auto-generated method stub
	User user=userRepository.findAll().stream().filter(i->i.getPhoneNumber()==phoneNumber).findAny().orElseThrow(()->new NoUserFoundException("No User Found:"));
	double travelCost=booking.getDistance()*10;
	if(user.getAge()>30 && user.getAge()<=50)
	{
		booking.setBookingPrice(travelCost-travelCost*0.05);
	}
	else if(user.getAge()>50)
	{
		booking.setBookingPrice(travelCost-0.1*travelCost);
	}
	else {
		booking.setBookingPrice(travelCost);
	}
	booking.setUser(user);
	user.getBookings().add(booking);
	userRepository.saveAndFlush(user);
}
@Override
public List<Booking> getBookings(long phoneNumber, String dateOfJourney) throws ServiceException {
	// TODO Auto-generated method stub
	List<Booking> bookings=new ArrayList<Booking>();
	User user=userRepository.findAll().stream().filter(i->i.getPhoneNumber()==phoneNumber).findAny().orElseThrow(()->new NoUserFoundException("No Such User Registered"));
	user.getBookings().stream().forEach(i->{if(i.getDateOfJourney().equals(dateOfJourney)) {bookings.add(i);}});
	if(bookings.size()==0)
	{
		throw new InvalidDateOfJourneyException("Invalid Date Of Journey:");
	}
	
	return bookings;
}
@Override
public Booking getBookingById(int bookingId) {
	// TODO Auto-generated method stub
     Booking booking=bookingRepository.getOne(bookingId);
	
	return booking;
}
@Override
public void editBooking(Booking booking,long phoneNumber) throws ServiceException {
	// TODO Auto-generated method stub
	User user=userRepository.findAll().stream().filter(i->i.getPhoneNumber()==phoneNumber).findAny().orElseThrow(()->new NoUserFoundException("No Such User Registered"));
	double travelCost=booking.getDistance()*10;
	if(user.getAge()>30 && user.getAge()<=50)
	{
		booking.setBookingPrice(travelCost-travelCost*0.05);
	}
	else if(user.getAge()>50)
	{
		booking.setBookingPrice(travelCost-0.1*travelCost);
	}
	else {
		booking.setBookingPrice(travelCost);
	}

	booking.setUser(user);
	/*user.getBookings().add(booking);
	userRepository.saveAndFlush(user);*/
	bookingRepository.saveAndFlush(booking);
	
}
}
