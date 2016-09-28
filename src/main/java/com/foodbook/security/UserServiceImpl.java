package com.foodbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.foodbook.model.User;
import com.foodbook.repository.UserRepository;

public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user;
		
		user = userRepository.loadUserByUsername(login);
		
		if( user == null)
			throw new UsernameNotFoundException("Usuário não encontrado.");
		
		return user;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;
		
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(user.getPassword());
		
		user.setPassword(cryptedPassword);
		
		userRepository.save(user);
		
	}
	
}
