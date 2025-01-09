package com.ecommerce.auth.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.auth.entity.User;
import com.ecommerce.auth.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{
	
	
	private final UserRepository repository;
	private final BCryptPasswordEncoder pwdEncoder;
		
	public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder pwdEncoder) {
		this.repository = repository;
		this.pwdEncoder = pwdEncoder;
	}
	
	@Override
	public Integer saveUser(User user) {
		
		//Encode password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return repository.save(user).getId();
		
		
	}
	//get user by user name
	public Optional<User> findByUsername(String username){
		return repository.findByUsername(username);
	}
	
	//-___----------------
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<User> opt=findByUsername(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("User not exits");
		//read user from Db
		User user=opt.get();
		
		return new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(), 
				user.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role))
				.collect(Collectors.toList())
				);
	}


}

