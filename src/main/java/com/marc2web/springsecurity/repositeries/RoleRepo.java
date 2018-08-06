package com.marc2web.springsecurity.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marc2web.springsecurity.dto.Role;

@Repository("roleRepo")
public interface RoleRepo extends JpaRepository<Role, Integer> {

	Role findByRole(String role);
}
