package com.cos.insta.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스

	@ManyToOne
	@JoinColumn(name = "userId")
	// 여러개 들어갈 수 있기 때문에 중괄호
	@JsonIgnoreProperties({ "password", "name", "website", "bio", "email", "phone", "gender", "createDate",
			"updateDate" })
	private User user; // id, username, profileImage

	@ManyToOne
	@JoinColumn(name = "imageId") // 연관관계에 걸려 있는 변수명
	@JsonIgnoreProperties({ "user", "likes" }) // 좋아요의 이미지의 유저정보 무시하기
	private Image image;

	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
}
