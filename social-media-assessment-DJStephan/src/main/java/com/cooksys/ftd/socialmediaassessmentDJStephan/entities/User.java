package com.cooksys.ftd.socialmediaassessmentDJStephan.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Profile profile;
	
	@Column(nullable = false)
	private Timestamp joined;
	
	@Column(nullable = false)
	private boolean active;
	
	@Column
	@ElementCollection(targetClass=String.class)
	private Set<String> following = new HashSet<String>();
	
	@Column
	@ElementCollection(targetClass=Long.class)
	private Set<Long> mentions = new HashSet<Long>();//tweets ids where mentioned
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Credentials credentials;
	
	public User() {}
	
	@Autowired
	public User(Credentials credentials, Profile profile) {
		this.credentials = credentials;
		this.username = this.credentials.getUsername();
		this.profile = profile;
		this.joined = new Timestamp(System.currentTimeMillis());
		this.active = true;
	}
	
	public void addFollow(String username) {
		this.following.add(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<String> getFollowing() {
		return following;
	}

	public void setFollowing(Set<String> following) {
		this.following = following;
	}

	public void removeFollow(String usernameToUnfollow) {
		this.following.remove(usernameToUnfollow);
		
	}

	public Set<Long> getMentions() {
		return mentions;
	}

	public void setMentions(Set<Long> mentions) {
		this.mentions = mentions;
	}
	
	
	
	
	
	
	
	

}
