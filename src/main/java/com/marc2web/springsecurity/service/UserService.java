package com.marc2web.springsecurity.service;

import java.util.List;

import com.marc2web.springsecurity.dto.Role;
import com.marc2web.springsecurity.dto.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public boolean addRole(Role role);
	public List<Role> getRoles(User user);
}
