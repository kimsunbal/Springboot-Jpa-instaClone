package com.cos.insta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.insta.model.User;
import com.cos.insta.repository.FollowRepository;
import com.cos.insta.repository.UserRepository;
import com.cos.insta.security.UserDetail;

@Controller
public class UserController {

	@Autowired
	private UserRepository mUserRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private FollowRepository mFollowRepository;

	@GetMapping("/auth/join")
	public String Join() {
		return "auth/join";
	}

	@PostMapping("/auth/joinProc")
	public String JoinAction(User user) {
		String rawPassword = user.getPassword();
		user.setPassword(passwordEncoder.encode(rawPassword));
		mUserRepository.save(user);
		return "auth/login";
	}

	@GetMapping("/auth/login")
	public String Login() {
		return "auth/login";
	}

	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id, @AuthenticationPrincipal UserDetail userDetail, Model model) {
		/*
		 * 1. id로 유저 검색 2. follower Count 3. following Count 4. User Object (Image
		 * Collection (Likes Count)) 5. followCheck 유무
		 */
		
		// 4번
		Optional<User> oUser = mUserRepository.findById(id);
		User user = oUser.get();
		model.addAttribute("user", user);

		// 5번
		User principal = userDetail.getUser();
		int followCheck = mFollowRepository.countByFromUserIdAndToUserId(principal.getId(), id);
		model.addAttribute("followCheck", followCheck);

		return "user/profile";
	}
}
