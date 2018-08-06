package com.marc2web.springsecurity.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user101")
public class User {

	Integer id;
	String email;
	String userName;
	String password;
	Boolean active;

	public Boolean getactive() {
		return active;
	}

	public void setactive(Boolean active) {
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
