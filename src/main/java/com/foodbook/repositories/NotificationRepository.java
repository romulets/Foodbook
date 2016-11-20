package com.foodbook.repositories;

import org.springframework.stereotype.Repository;

import com.foodbook.models.Notification;

@Repository
public class NotificationRepository extends AbstractRepository<Notification> {

	public NotificationRepository() {
		super(Notification.class);
	}
	
}
