package com.cooksys.ftd.socialmediaassessmentDJStephan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Long>{

	HashTag findHashTagByLabel(String label);

}
