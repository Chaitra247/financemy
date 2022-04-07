package com.financialorgratingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
 @Autowired
 UserService userService;
 
// http://localhost:8088/api/user/add
	@PostMapping("/add")
	public ResponseEntity<User> insertUser(
			@RequestBody User user){
		User user1= userService.addUser(user);
		if(user1==null)
		{
			return new ResponseEntity("Sorry! User not added!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
//	http://localhost:8088/api/user/login
	@GetMapping("/login/{userId}/{password}")
	public ResponseEntity<User> validateUser(@PathVariable("userId") int userId,@PathVariable("password") String password) throws UserNotFoundException{
	
		User user1= userService.validateUser(userId,password);
		if(user1==null)
		{
			throw new UserNotFoundException();
		}
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
//	http://localhost:8088/api/user/get/1
	@GetMapping("get/{userId}")
	public ResponseEntity<User> getUserById(
			@PathVariable("userId")Integer userId) throws UserNotFoundException{
		User user= userService.getUserById(userId);
		if(user==null) {
		throw new UserNotFoundException();
	}
		
		return new ResponseEntity <User>(user, HttpStatus.OK);
	}


}
