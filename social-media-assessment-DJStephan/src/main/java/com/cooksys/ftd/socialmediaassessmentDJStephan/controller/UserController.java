package com.cooksys.ftd.socialmediaassessmentDJStephan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.CredentialsDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.ProfileDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.dtos.UserDto;
import com.cooksys.ftd.socialmediaassessmentDJStephan.entities.User;
import com.cooksys.ftd.socialmediaassessmentDJStephan.services.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("users")
	public UserDto[] getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping("users")
	public UserDto createUser(@RequestBody CredentialsDto credentialsDto, @RequestBody ProfileDto profileDto) {
		return this.userService.createUser(credentialsDto, profileDto);
	}
	
	@GetMapping("users/@{username}")
	public UserDto getUser(@RequestParam(name = "username") String username){
		return this.userService.getUser(username);
	}
	
	@PatchMapping("users/@{username}")
	public UserDto updateUserProfile(@RequestParam(name = "username") String username, @RequestBody CredentialsDto credentialsDto, @RequestBody ProfileDto profileDto) {
		return this.userService.updateUserProfile(username, credentialsDto, profileDto);
	}
	
	@DeleteMapping("users/@{username}")
	public UserDto deleteUser(@RequestParam String username, @RequestBody CredentialsDto credentialsDto) {
		return this.userService.deleteUser(username, credentialsDto);
	}
}
