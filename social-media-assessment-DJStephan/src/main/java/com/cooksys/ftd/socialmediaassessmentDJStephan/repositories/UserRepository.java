package com.cooksys.ftd.socialmediaassessmentDJStephan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
