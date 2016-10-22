package com.foodbook.service;

import org.springframework.security.core.Authentication;

import com.foodbook.model.Notification;

public interface FriendService {

	public boolean accept(Notification notification, Authentication auth);
	
	public boolean refuse(Notification notification, Authentication auth);
	
	public boolean send(Notification notification, Authentication auth);
	
}
