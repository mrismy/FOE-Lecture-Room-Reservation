package com.rismy.FoE_RoomReservation.service.interfac;

import java.util.List;

import com.rismy.FoE_RoomReservation.dto.NotificationDto;

public interface NotificationService {

	List<String> getLoggedUserMessage();

	List<String> getOtherUserMessage();

	String getLoggedUserMail();

	String[] getOtherUsersMail();

	NotificationDto getNotification();

	void setNotification(NotificationDto notificationDto);

}
