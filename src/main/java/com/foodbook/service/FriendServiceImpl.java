package com.foodbook.service;

import java.util.Date;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.foodbook.model.Notification;
import com.foodbook.model.User;
import com.foodbook.repository.NotificationRepository;
import com.foodbook.repository.UserRepository;

@Service
@Primary
public class FriendServiceImpl implements FriendService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean accept(Notification notification, Authentication auth) {
		User newFriend;
		User currentUser = (User) auth.getPrincipal();
		
		notification = notificationRepository.findById(notification.getIdNotification());
		
		// User answering notification is not the same that currentUser
		if (notification.getNotificationTo().getIdUser() != currentUser.getIdUser())
			return false;
		
		newFriend = userRepository.findById(notification.getNotificationFrom().getIdUser());
		
		notification.setStatus((byte) 1);
		currentUser.getFriends().add(newFriend);
		
		userRepository.update(currentUser);
		notificationRepository.update(notification);
		
		return true;
	}

	@Override
	public boolean refuse(Notification notification, Authentication auth) {
		User currentUser = (User) auth.getPrincipal();
		notification = notificationRepository.findById(notification.getIdNotification());
		
		// User answering notification is not the same that currentUser
		if (notification.getNotificationTo().getIdUser() != currentUser.getIdUser())
			return false;
		
		notification.setStatus((byte) 2);
		notificationRepository.update(notification);
		
		return true;
	}

	@Override
	public boolean send(Notification notification, Authentication auth) {
		User notificationTo;
		User notificationFrom;
		
		try {
			notificationTo = userRepository.findById(notification.getNotificationTo().getIdUser());
			notificationFrom = (User) auth.getPrincipal();
			
			notification.setSendDate(new Date());
			notification.setNotificationTo(notificationTo);
			notification.setNotificationFrom(notificationFrom);
			
			// DELETE THE CODE BELOW AFTER TESTS EXCEPT THE CALL OF SAVE
			notification.setStatus((byte) 1);
			notificationTo.getFriends().add(notificationFrom);
			
			userRepository.update(notificationTo);
			notificationRepository.update(notification);
			
			notificationRepository.save(notification);
			
		} catch(Exception error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}
	
}
