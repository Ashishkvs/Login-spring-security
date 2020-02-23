package com.imagegrafia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.imagegrafia.entity.Role;
import com.imagegrafia.entity.UserAccount;
import com.imagegrafia.repository.RoleRepository;
import com.imagegrafia.repository.UserRepository;

@Service
public class UserAccountService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	public UserAccount createUser(UserAccount user) {
		user.setEmail(user.getEmail().toLowerCase());
		String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encoded);

		// SET Additional param for Authentication
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setCredentialsNonExpired(true);
		user.setAccountNonLocked(true);
		UserAccount newUser = userRepository.save(user);

		// SET DEFAULT ROLE FOR NEW USER
		Role role = new Role();
		role.setRole("ROLE_USER ");
		role.setUserAccount(newUser);
		roleRepository.save(role);

		return newUser;
	}

}
