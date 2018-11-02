package com.cooksys.ftd.socialmediaassessmentDJStephan.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{


	Tweet[] findByAuthorInOrderByPostedDesc(Set<String> following);

	//Tweet[] findByAuthorOrderByDesc(String username);

	Tweet[] findByIdIn(Set<Long> mentions);

	Tweet[] findByAuthorOrderByPostedDesc(String username);

	
	
	

}
