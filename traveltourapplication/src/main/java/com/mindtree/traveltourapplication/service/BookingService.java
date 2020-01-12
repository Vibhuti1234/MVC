package com.mindtree.traveltourapplication.service;

import java.util.List;

import com.mindtree.traveltourapplication.entity.Booking;
import com.mindtree.traveltourapplication.exception.ServiceException;

public interface BookingService {

	void addBookingToUser(Booking booking, long phoneNumber) throws ServiceException;

	List<Booking> getBookings(long phoneNumber, String dateOfJourney) throws ServiceException;

     Booking getBookingById(int bookingId);

	void editBooking(Booking booking,long phoneNumber) throws ServiceException;

}
