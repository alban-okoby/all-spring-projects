package com.digitalsouag.portfolio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalsouag.portfolio.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("SELECT email FROM User email WHERE email.email = ?1 ")
	Optional<User> findByEmail(String email);
}
