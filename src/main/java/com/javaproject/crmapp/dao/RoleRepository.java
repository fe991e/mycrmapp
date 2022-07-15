package com.javaproject.crmapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.crmapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
