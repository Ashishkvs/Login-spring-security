package com.imagegrafia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.imagegrafia.entity.Role;
import com.imagegrafia.entity.User;
import com.imagegrafia.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Use default login-page and logout for Login given by spring security
 */
@Controller
@Slf4j
public class HomeController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@GetMapping("/reg")
	public String regForm(Model model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@PostMapping("/reg")
	public String userRegForm(@ModelAttribute User user, Model model) {
		model.addAttribute("user", new User());
		log.info("User obj: {} ", user);
		userService.createUser(user);
		return "user";
	}

}
