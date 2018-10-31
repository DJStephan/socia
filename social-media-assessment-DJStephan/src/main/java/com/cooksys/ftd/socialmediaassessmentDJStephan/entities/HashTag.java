package com.cooksys.ftd.socialmediaassessmentDJStephan.entities;

import java.sql.Timestamp;

public class HashTag {
	
	private String label;
	private Timestamp firstUsed;
	private Timestamp lastUsed;
	
	public HashTag(String label) {
		this.label = label;
		this.firstUsed = new Timestamp(System.currentTimeMillis());
		this.lastUsed = new Timestamp(System.currentTimeMillis()); 
	}

	public String getLabel() {
		return label;
	}

	public Timestamp getFirstUsed() {
		return firstUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}
	
	

}
