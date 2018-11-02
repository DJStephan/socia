package com.cooksys.ftd.socialmediaassessmentDJStephan.entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private Timestamp posted;

	@Column
	private String content;

	@Column
	//@ElementCollection(targetClass=String.class)
	private String inReplyTo;

	@Column
	//@ElementCollection(targetClass=String.class)
	private String repostOf;

	public Tweet() {
	}

	public Tweet(String author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(String inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public String getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(String repostOf) {
		this.repostOf = repostOf;
	}


}
