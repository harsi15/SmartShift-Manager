package com.syr.zen.employee_service.dto;

import lombok.Data;

@Data
public class Employee {

	private Integer id;
	private String name;
	private String mailId;
	private Integer emp_id;
	private String passwd;
	private String verification_of_passwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getVerification_of_passwd() {
		return verification_of_passwd;
	}

	public void setVerification_of_passwd(String verification_of_passwd) {
		this.verification_of_passwd = verification_of_passwd;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}


}
