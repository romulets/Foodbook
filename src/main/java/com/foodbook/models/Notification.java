package com.foodbook.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idNotification;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date sendDate;
	
	/*
	 * 0 - Waiting answer.
	 * 1 - Accepted.
	 * 2 - Refused.
	 */
	@Column
	private byte status;
	
	@ManyToOne
	@JoinColumn(name="notificationTo_user_fk")
	private User notificationTo;
	
	@ManyToOne
	@JoinColumn(name="notificationFrom_user_fk")
	private User notificationFrom;

	public Notification() {
		super();
	}

	public Notification(Integer idNotification, Date sendDate, byte status, User notificationTo,
			User notificationFrom) {
		super();
		this.idNotification = idNotification;
		this.sendDate = sendDate;
		this.status = status;
		this.notificationTo = notificationTo;
		this.notificationFrom = notificationFrom;
	}

	public Integer getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public User getNotificationTo() {
		return notificationTo;
	}

	public void setNotificationTo(User notificationTo) {
		this.notificationTo = notificationTo;
	}

	public User getNotificationFrom() {
		return notificationFrom;
	}

	public void setNotificationFrom(User notificationFrom) {
		this.notificationFrom = notificationFrom;
	}

	@Override
	public String toString() {
		return "Notification [idNotification=" + idNotification + ", sendDate=" + sendDate + ", status=" + status + "]";
	}
	
}
