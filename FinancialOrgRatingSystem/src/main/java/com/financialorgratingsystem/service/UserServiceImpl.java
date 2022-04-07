package com.financialorgratingsystem.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Transactional
	@Override
	public User addUser(User u) {
		User user = userRepo.save(u);
		return user;
	}

	@Override
	public User validateUser(int userId, String password)throws UserNotFoundException {
		
		if(userRepo.existsById(userId))
		{
			return userRepo.validateUserCredentials(userId, password);
		}
		 return null;
	}

	@Override
	public User getUserById(Integer userId)throws UserNotFoundException {
		if(userRepo.existsById(userId)) {
	 return	userRepo.getById(userId);
    }
		 return null;
}
}