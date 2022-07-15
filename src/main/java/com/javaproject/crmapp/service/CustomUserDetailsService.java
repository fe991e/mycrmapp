package com.javaproject.crmapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaproject.crmapp.dao.UserRepository;
import com.javaproject.crmapp.entity.CustomUserDetails;
import com.javaproject.crmapp.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = Optional.of(userRepo.findByUsername(username));
		user.orElseThrow(()-> new UsernameNotFoundException("Username not Found!"));

		return user.map(CustomUserDetails::new).get();
	}
}
