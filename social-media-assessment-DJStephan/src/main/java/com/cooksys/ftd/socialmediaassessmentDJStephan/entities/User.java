package com.cooksys.ftd.socialmediaassessmentDJStephan.entities;

import java.sql.Timestamp;

public class User {
	
	private String userName;
	private Profile profile;
	private Timestamp joined;
	
	public User(String userName, Profile profile) {
		this.userName = userName;
		this.profile = profile;
		this.joined = new Timestamp(System.currentTimeMillis());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}
	
	

}
