package com.syr.zen.employee_service.dto;

import lombok.Data;

@Data
public class Verification {

	private String id;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
