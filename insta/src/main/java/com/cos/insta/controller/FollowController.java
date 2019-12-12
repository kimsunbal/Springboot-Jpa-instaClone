package com.cos.insta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.insta.model.Follow;
import com.cos.insta.model.User;
import com.cos.insta.repository.FollowRepository;
import com.cos.insta.repository.UserRepository;
import com.cos.insta.security.UserDetail;

@Controller
public class FollowController {

	@Autowired
	private UserRepository mUserRepository;

	@Autowired
	private FollowRepository mFollowRepository;

	// resposeEntity
	@PostMapping("/follow/{id}")
	public @ResponseBody String follw(@AuthenticationPrincipal UserDetail userDetail, @PathVariable int id) {
		User fromUser = userDetail.getUser();
		Optional<User> oToUser = mUserRepository.findById(id); // findBy는 Optional로 return
		User toUser = oToUser.get();

		Follow follow = new Follow();
		follow.setFromUser(fromUser);
		follow.setToUser(toUser);
		mFollowRepository.save(follow);
		return "ok";
	}

	@DeleteMapping("/follow/{id}")
	public @ResponseBody String unFollow(@AuthenticationPrincipal UserDetail userDetail, @PathVariable int id) {
		User fromUser = userDetail.getUser();
		Optional<User> oToUser = mUserRepository.findById(id); // findBy는 Optional로 return
		User toUser = oToUser.get();

		mFollowRepository.deleteByFromUserIdAndToUserId(fromUser.getId(), toUser.getId());

//		List<Follow> followList = mFollowRepository.findAll();

		return "ok";
	}

}
