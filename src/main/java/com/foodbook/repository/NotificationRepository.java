package com.foodbook.repository;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Notification;

@Repository
public class NotificationRepository extends AbstractRepository<Notification> {

	public NotificationRepository() {
		super(Notification.class);
	}
	
}
