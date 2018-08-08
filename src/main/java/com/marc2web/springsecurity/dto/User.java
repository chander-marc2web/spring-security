package com.marc2web.springsecurity.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	@NotEmpty(message="Email Can not be empty!")
	@Email(message="Please Enter a valid email address!")
	//@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$",message="please enter valid email address!")
	private String email;
	@Size(max=20,min=5,message="User Name length should be in between 5-20")
	private String userName;
	@Size(min=8,message="Password length should be in between 8-16 characters!")
	//@Pattern(regexp="[0-9]",message="please enter valid password! Contains numbers,alphabates and special characters!")
	private String password;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", userName=" + userName + ", password=" + password + ", active="
				+ active + ", role=" + role + "]";
	}

	private Boolean active;
	
	private String role;

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

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
