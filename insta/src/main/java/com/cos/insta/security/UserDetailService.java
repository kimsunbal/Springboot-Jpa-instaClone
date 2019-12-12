package com.cos.insta.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.insta.model.User;
import com.cos.insta.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository mRepo;
	
	// loginForm에서 action="user/loginProcess"
	// 로그인 버튼을 누르면 컨피그에서 낚아채서 여기가 작동한다.
	// 내부를 구현해주면 끝
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = mRepo.findByUsername(username);
		UserDetail userDetails = null;
		
		if(user != null) {
			System.out.println("유저네임 있어");
			userDetails = new UserDetail();
			userDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("Not Found 'username'");
		}
		return userDetails;
	}

	
}