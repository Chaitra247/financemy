package com.financialorgratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.financialorgratingsystem.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	@Query("Select u from User u where u.userId=?1 and u.password=?2")
public	User validateUserCredentials(int userId,String password);

}
