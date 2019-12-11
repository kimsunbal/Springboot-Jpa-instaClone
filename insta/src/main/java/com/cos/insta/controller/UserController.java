package com.cos.insta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.insta.model.User;
import com.cos.insta.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/auth/join")
	public String Join() {
		return "auth/join";
	}

	@PostMapping("/auth/joinProc")
	public String JoinAction(User user) {
		String rawPassword = user.getPassword();
		user.setPassword(passwordEncoder.encode(rawPassword));
		userRepo.save(user);
		return "auth/login";
	}

	@GetMapping("/auth/login")
	public String Login() {
		return "auth/login";
	}
}
