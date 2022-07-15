package com.javaproject.crmapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.crmapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
