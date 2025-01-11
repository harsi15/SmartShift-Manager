package com.syr.zen.shift_service.dto;

import lombok.Data;

@Data
public class EventSheet {

	private Integer id;
	private Integer eventId;
	private Integer empId;
	private String name;
	private String mailId;
	private Integer count;
	private String timestamp;

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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Integer getCount() {
		return empId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
