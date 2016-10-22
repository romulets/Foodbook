package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.Notification;
import com.foodbook.model.User;
import com.foodbook.repository.UserRepository;
import com.foodbook.service.FriendServiceImpl;

@Controller
public class FriendController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FriendServiceImpl friendService;

	@RequestMapping(value="send", method=RequestMethod.POST)
	public String sendNotification(
			@ModelAttribute("notification") Notification notification,
			Authentication auth,
			BindingResult result,
			Model model) {
		friendService.send(notification, auth);
		
		// These two lines below are only for test purposes.
		model.addAttribute("notification", new Notification());
		model.addAttribute("idNotification", notification.getIdNotification());
		
		// Change it
		return "to_delete/notification_receiveid";
	}
	
	@RequestMapping(value="send", method=RequestMethod.GET)
	public String sendNotification(Model model, Authentication auth) {
		User userTo = userRepository.findById(1);
		
		model.addAttribute("userTo", userTo);
		model.addAttribute("notification", new Notification());
		
		// Change it
		return "to_delete/notification_send";
	}
	
	@RequestMapping(value="accept", method=RequestMethod.POST)
	public String refuseNotification(
			@ModelAttribute("notification") Notification notification,
			Authentication auth,
			BindingResult result) {
		friendService.accept(notification, auth);
		
		// Change it
		return "to_delete/notification_send";
	}
	
	@RequestMapping(value="refuse", method=RequestMethod.POST)
	public String acceptNotification(
			@ModelAttribute("notification") Notification notification,
			Authentication auth,
			BindingResult result) {
		friendService.refuse(notification, auth);
		
		// Change it
		return "to_delete/notification_send";
	}
	
}
