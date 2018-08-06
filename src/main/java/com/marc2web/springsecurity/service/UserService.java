package com.marc2web.springsecurity.service;

import com.marc2web.springsecurity.dto.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUserAsUser(User user);
}
