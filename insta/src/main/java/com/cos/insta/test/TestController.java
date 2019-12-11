package com.cos.insta.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	@GetMapping("/test/home")
	public String testHome() {
		return "home";
	}
	@GetMapping("/test/login")
	public String testLogin() {
		return "auth/login";
	}
	@GetMapping("/test/profile")
	public String testProfile() {
		return "user/profile";
	}
	@GetMapping("/test/profileEdit")
	public String testProfileEdit() {
		return "user/profile_edit";

	}
	@GetMapping("/test/feed")
	public String testFeed() {
		return "image/feed";

	}
	@GetMapping("/test/imageUpload")
	public String testImageUpload() {
		return "image/imageUpload";

	}
}
