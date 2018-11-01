package com.cooksys.ftd.socialmediaassessmentDJStephan.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.CredentialsDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.ProfileDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.UserDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.Credentials;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.Profile;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.User;
import com.cooksys.ftd.socialmediaassessmentDJStephan.mappers.CredentialsMapper;
import com.cooksys.ftd.socialmediaassessmentDJStephan.mappers.ProfileMapper;
import com.cooksys.ftd.socialmediaassessmentDJStephan.mappers.UserMapper;
import com.cooksys.ftd.socialmediaassessmentDJStephan.repositories.CredentialsRepository;
import com.cooksys.ftd.socialmediaassessmentDJStephan.repositories.ProfileRepository;
import com.cooksys.ftd.socialmediaassessmentDJStephan.repositories.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	private CredentialsRepository credendentialsRrepository;
	
	private ProfileRepository profileRepository;
	
	private UserMapper usermapper;
	
	private CredentialsMapper credentialsmapper;
	
	private ProfileMapper profileMapper;
	
	@Autowired
	public UserService(UserRepository userRepository, UserMapper  userMapper, CredentialsMapper credentialsMapper, ProfileMapper profileMapper ) {
		this.userRepository = userRepository;
		this.usermapper = userMapper;
		this.credentialsmapper = credentialsMapper;
		this.profileMapper = profileMapper;
	}

	public UserDto[] getUsers() {
		User[] users = this.userRepository.getAllUsers();
		return this.usermapper.usersToUserDtos(users);
		 
	}

	public UserDto createUser(CredentialsDto credentialsDto, ProfileDto profileDto) {// throws usernameExists
		Credentials credentials = this.credentialsmapper.credentialsDtoToCredentials(credentialsDto);
		Profile profile = this.profileMapper.profileDtoToProfile(profileDto);
		Credentials databaseCredentials = this.credendentialsRrepository.findByUsername(credentials.getUsername());
		
		if(databaseCredentials != null && databaseCredentials.getPassword().equals(credentials.getPassword())) {
			User user = this.userRepository.findByUserName(credentials.getUsername());
			if(user.isActive()) {
				//throw error, user already exists
			}else {
				user.setActive(true);
				this.userRepository.saveAndFlush(user);
				UserDto userDto = this.usermapper.userToUserDto(user);
				return userDto;
			}
		}else if(databaseCredentials != null) {
			//throw error, user already exists
		}
		
		User newUser = new User(credentials, profile);
		userRepository.saveAndFlush(newUser);
		profileRepository.saveAndFlush(profile);
		credendentialsRrepository.saveAndFlush(credentials);
		
		
		
		return this.usermapper.userToUserDto(newUser);
	}
	
	public UserDto getUser(String username) {//throws usernotfound
		User user = userRepository.findByUserName(username);
		if(user == null || !(user.isActive())) {
			//throw error, usernotfouns
		}
		return this.usermapper.userToUserDto(user);
	}
	
	public UserDto updateUserProfile(String username, CredentialsDto credentialsDto, ProfileDto profileDto) {
		if(!(username.equals(credentialsDto.getUserName()))) {
			//throw error usernames don't match
		}
		Credentials databaseCredentials = credendentialsRrepository.findByUsername(credentialsDto.getUserName());
		Credentials credentials = credentialsmapper.credentialsDtoToCredentials(credentialsDto);
		if(!(databaseCredentials.equals(credentials))) {
			//throw error credentials don't match
		}
		User user = userRepository.findByUserName(username);
		if(!(user.isActive())) {
			//throw error cantfinduser
		}
		Profile profile = profileMapper.profileDtoToProfile(profileDto);
		user.setProfile(profile);
		userRepository.saveAndFlush(user);
		return usermapper.userToUserDto(user);
	}

	public UserDto deleteUser(String username, CredentialsDto credentialsDto) {
		
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserMapper getUsermapper() {
		return usermapper;
	}

	public void setUsermapper(UserMapper usermapper) {
		this.usermapper = usermapper;
	}

	public CredentialsMapper getCredentialsmapper() {
		return credentialsmapper;
	}

	public void setCredentialsmapper(CredentialsMapper credentialsmapper) {
		this.credentialsmapper = credentialsmapper;
	}

	public ProfileMapper getProfileMapper() {
		return profileMapper;
	}

	public void setProfileMapper(ProfileMapper profileMapper) {
		this.profileMapper = profileMapper;
	}




	
	
	

}
