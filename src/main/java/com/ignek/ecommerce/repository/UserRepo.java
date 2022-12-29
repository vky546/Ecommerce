package com.ignek.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ignek.ecommerce.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	 Optional<User> findUserByEmail(String email);

}
