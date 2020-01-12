package com.mindtree.traveltourapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.traveltourapplication.entity.Booking;
import com.mindtree.traveltourapplication.entity.User;
import com.mindtree.traveltourapplication.exception.ServiceException;
import com.mindtree.traveltourapplication.service.BookingService;
import com.mindtree.traveltourapplication.service.UserService;

@Controller
public class TravelTourController {
	@Autowired
	UserService userService;
    @Autowired
    BookingService bookingService;
  
    @RequestMapping("/")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal());
        return "index";
    }
    @RequestMapping("/callback")
    public String callback() {
        System.out.println("redirecting to home page");
        return "menu";
    }

  /* @RequestMapping("/")
    public String menu()
   {
   	return "menu";
   }*/
   @RequestMapping("/signup")
    public String signup()
   {
  	return "signup";
   }
    @RequestMapping("/signin")
  public String signin()
    {
    	return "signin";
   }
   @PostMapping("/registerUser")
    public String registerUser(User user)
    {   userService.registerUser(user);
   	return "menu";
    }
    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("userName") String userName,@RequestParam("phoneNumber") long phoneNumber,Model model) throws ServiceException
    {
    	boolean x=userService.getUser(userName,phoneNumber);
    	model.addAttribute("users", userService.getAllUsers());
    	
    	if(x==true)
    	{
    		return "travelBooking";
    	}
    	else {
    		return "signin";
    	}
    }
    @PostMapping("/addBooking")
    public String addBooking(Booking booking,@RequestParam("phoneNumber") long phoneNumber) throws ServiceException
    {
    	bookingService.addBookingToUser(booking,phoneNumber);
    	return "menu";
    }
    @RequestMapping("/display")
    public String display(Model model)
    {
    	model.addAttribute("users", userService.getAllUsers());
    	return "display";
    }
    @GetMapping("/displayBooking")
    public String displayBooking(@RequestParam("phoneNumber") long phoneNumber,@RequestParam("dateOfJourney") String dateOfJourney,Model model) throws ServiceException
    {
    	List<Booking> bookings=bookingService.getBookings(phoneNumber,dateOfJourney);
    	model.addAttribute("bookings", bookings);
    	return "display";
    }
    @RequestMapping("/update")
    public String updateBooking(@RequestParam("bookingId") int bookingId,Model model)
    {
    	model.addAttribute("booking",bookingService.getBookingById(bookingId));
    	return "edit";
    }
    @PostMapping("/editBooking")
    public String editBooking(Booking booking,@RequestParam("phoneNumber") long phoneNumber) throws ServiceException
    {
    	bookingService.editBooking(booking,phoneNumber);
    	return "menu";
    }
    
    }
    
