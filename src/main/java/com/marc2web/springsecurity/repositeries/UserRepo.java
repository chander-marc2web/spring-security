package com.marc2web.springsecurity.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marc2web.springsecurity.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
}
