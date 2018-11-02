package com.cooksys.ftd.socialmediaassessmentDJStephan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.HashTagDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.HashTag;
import com.cooksys.ftd.socialmediaassessmentDJStephan.mappers.HashTagMapper;
import com.cooksys.ftd.socialmediaassessmentDJStephan.repositories.HashTagRepository;
@Service
public class HashTagService {
	
	HashTagRepository hashTagRepository;
	
	HashTagMapper hashTagMapper;
	
	@Autowired
	public HashTagService(HashTagRepository hashTagReposity, HashTagMapper hashTagMapper) {
		this.hashTagRepository = hashTagReposity;
		this.hashTagMapper = hashTagMapper;
	}

	public HashTagDto[] getHashTags() {
		List<HashTag> hashTags = hashTagRepository.findAll();
		return hashTagMapper.hashTagsToHashTagDtos(hashTags);
	}

}
