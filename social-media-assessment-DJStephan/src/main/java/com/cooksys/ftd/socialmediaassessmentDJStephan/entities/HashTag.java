package com.cooksys.ftd.socialmediaassessmentDJStephan.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class HashTag {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String label;
	@Column(nullable = false)
	private Timestamp firstUsed;
	@Column(nullable = false)
	private Timestamp lastUsed;
	
	public HashTag(String label) {
		this.label = label;
		this.firstUsed = new Timestamp(System.currentTimeMillis());
		this.lastUsed = new Timestamp(System.currentTimeMillis()); 
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public void setFirstUsed(Timestamp firstUsed) {
		this.firstUsed = firstUsed;
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
