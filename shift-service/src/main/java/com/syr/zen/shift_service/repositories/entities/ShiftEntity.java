package com.syr.zen.shift_service.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventdetails")
public class ShiftEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
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

	@Column(name = "event_id")
	private Integer eventId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_date")
	private String eventDate;

	@Column(name = "event_day")
	private String eventDay;

	@Column(name = "event_time")
	private String eventTime;

	@Column(name = "number_of_employee")
	private Integer number_of_employee;

	public Integer getNumber_of_employee() {
		return number_of_employee;
	}

	public void setNumber_of_employee(Integer number_of_employee) {
		this.number_of_employee = number_of_employee;
	}
}
