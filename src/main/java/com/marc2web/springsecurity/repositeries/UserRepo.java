package com.marc2web.springsecurity.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marc2web.springsecurity.dto.User;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
