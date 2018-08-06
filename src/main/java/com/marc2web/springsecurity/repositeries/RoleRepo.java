package com.marc2web.springsecurity.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marc2web.springsecurity.dto.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
