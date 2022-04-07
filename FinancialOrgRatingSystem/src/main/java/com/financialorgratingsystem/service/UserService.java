package com.financialorgratingsystem.service;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;

public interface UserService {

	public User addUser(User u);
	public User validateUser(int userId,String password)throws UserNotFoundException;
    public User getUserById(Integer userId)throws UserNotFoundException;

	
}
