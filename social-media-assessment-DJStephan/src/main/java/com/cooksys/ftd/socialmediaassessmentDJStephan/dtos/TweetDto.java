package com.cooksys.ftd.socialmediaassessmentDJStephan.dtos;

import java.sql.Timestamp;

import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.Tweet;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.User;

public class TweetDto {
	
	private Long id;
	
	private String author;
	
	private Timestamp posted;
	
	private String content;
	
	private String inReplyTo;
	
	private String repostOf;

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
