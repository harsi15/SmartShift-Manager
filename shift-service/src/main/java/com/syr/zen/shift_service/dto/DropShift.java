package com.syr.zen.shift_service.dto;

import lombok.Data;

@Data
public class DropShift {

	private Integer empId;
	private Integer eventId;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
}
