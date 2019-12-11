package com.cos.insta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.insta.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
