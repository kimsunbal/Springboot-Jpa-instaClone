package com.cos.insta.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스

	@ManyToOne
	@JoinColumn(name = "fromUserId")
	@JsonIgnoreProperties({ "images" })
	private User fromUser;

	@ManyToOne
	@JoinColumn(name = "toUserId")
	@JsonIgnoreProperties({ "images" })
	private User toUser;

	@Transient
	private boolean matpal;

	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
}
