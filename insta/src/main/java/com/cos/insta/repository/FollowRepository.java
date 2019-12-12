package com.cos.insta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.insta.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	// unFollow
	@Transactional
	void deleteByFromUserIdAndToUserId(int fromUserId, int toUserId);

	int countByFromUserIdAndToUserId(int fromUserId, int toUserId);
}
