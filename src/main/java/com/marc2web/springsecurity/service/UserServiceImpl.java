package com.marc2web.springsecurity.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marc2web.springsecurity.dto.Role;
import com.marc2web.springsecurity.dto.User;
import com.marc2web.springsecurity.repositeries.RoleRepo;
import com.marc2web.springsecurity.repositeries.UserRepo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	EntityManager entityManager;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncode;
	@Autowired
	RoleRepo roleRepo;

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);

	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
		Set<Role> roleSet = new HashSet<Role>();
		roleSet.add(roleRepo.findByRole("USER"));
		user.setRoles(roleSet);
		userRepo.save(user);

	}

	@Override
	public boolean addRole(Role role) {

		return false;
	}

	@Override
	public List<Role> getRoles(User user) {
		String query = "from Role where users=:user";
		return entityManager.createQuery(query).setParameter(0, user).getResultList();

	}

}
