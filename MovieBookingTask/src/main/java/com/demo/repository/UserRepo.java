package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long>
{
	User findByEmail(String email);
}
