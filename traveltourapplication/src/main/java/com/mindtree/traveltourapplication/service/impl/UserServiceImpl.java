package com.mindtree.traveltourapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.traveltourapplication.entity.User;
import com.mindtree.traveltourapplication.exception.InvalidPasswordException;
import com.mindtree.traveltourapplication.exception.InvalidUserNameException;
import com.mindtree.traveltourapplication.exception.ServiceException;
import com.mindtree.traveltourapplication.repository.BookingRepository;
import com.mindtree.traveltourapplication.repository.UserRepository;
import com.mindtree.traveltourapplication.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRepository;
@Autowired
BookingRepository bookingRepository;
@Override
public void registerUser(User user) {
	// TODO Auto-generated method stub
userRepository.save(user);
	
}
@Override
public boolean getUser(String userName, long phoneNumber) throws ServiceException {
	// TODO Auto-generated method stub
	User user=userRepository.findAll().stream().filter(i->i.getPhoneNumber()==phoneNumber).findAny().orElseThrow(()->new InvalidPasswordException("Invalid Password Exception"));
	if(user.getUserName().equals(userName)==false)
	{
		throw new InvalidUserNameException("Invalid User Name:");
	}
	return true;
	
}
@Override
public List<User> getAllUsers() {
	// TODO Auto-generated method stub
	return userRepository.findAll();
}

}
