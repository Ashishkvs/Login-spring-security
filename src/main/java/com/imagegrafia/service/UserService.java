package com.imagegrafia.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.imagegrafia.entity.Role;
import com.imagegrafia.entity.User;
import com.imagegrafia.repository.RoleRepository;
import com.imagegrafia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	public User createUser(User user) {
		String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encoded);
		User newUser = userRepository.save(user);
		
		Role role = new Role();
		role.setRole("ROLE_USER ");
		role.setUser(newUser);
		roleRepository.save(role);
		
		return newUser;
	}

}
