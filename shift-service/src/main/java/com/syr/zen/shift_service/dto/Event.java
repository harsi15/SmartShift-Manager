package com.syr.zen.shift_service.dto;

import lombok.Data;

@Data
public class Event {

	private Integer id;
	private Integer eventId;
	private String eventName;
	private String eventDate;
	private String eventDay;
	private String eventTime;
	private Integer number_of_employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDay() {
		return eventDay;
	}

	public void setEventDay(String eventDay) {
		this.eventDay = eventDay;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getNumber_of_employee() {
		return number_of_employee;
	}

	public void setNumber_of_employee(Integer number_of_employee) {
		this.number_of_employee = number_of_employee;
	}
}
