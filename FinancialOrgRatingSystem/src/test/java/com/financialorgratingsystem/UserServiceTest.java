package com.financialorgratingsystem;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.repository.UserRepo;
import com.financialorgratingsystem.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserRepo userRepo;

	User u1;

	@BeforeEach
	void setUp() throws Exception {

	u1= new User();
		u1.setUserId(1);
		u1.setUserName("Chaitra R");
		u1.setContactNumber("5678998899");
		u1.setPassword("cg21");
		u1.setEmailId("adfhg@gmail.com");
		u1.setFirstName("Chai");
		u1.setLastName("R");
	}

	@Test
	void testAddUser() {
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userService.addUser(u1)).isEqualTo(u1);
	}

	@Test
	void testgetUserById() throws UserNotFoundException {

		Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
		Mockito.when(userRepo.getById(u1.getUserId())).thenReturn(u1);
		assertThat(userService.getUserById(u1.getUserId())).isEqualTo(u1);

	}

	@Test
	void testvalidateUser() throws UserNotFoundException {

		Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
		Mockito.when(userRepo.validateUserCredentials(u1.getUserId(), u1.getPassword())).thenReturn(u1);
		assertThat(userService.validateUser(u1.getUserId(), u1.getPassword())).isEqualTo(u1);

	}
}
