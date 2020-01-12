package com.mindtree.traveltourapplication.service;

import java.util.List;

import com.mindtree.traveltourapplication.entity.User;
import com.mindtree.traveltourapplication.exception.ServiceException;

public interface UserService {

	void registerUser(User user);
   boolean getUser(String userName, long phoneNumber) throws ServiceException;
 List<User> getAllUsers();

}
