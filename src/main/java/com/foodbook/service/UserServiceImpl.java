package com.foodbook.service;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodbook.model.User;
import com.foodbook.repository.AddressRepository;
import com.foodbook.repository.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user;
		
		user = userRepo.loadUserByUsername(login);
		
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
		
		if(user.getAddress() != null)
			addressRepo.save(user.getAddress());
		
		if(user.getCreationDate() == null) {
			long now = GregorianCalendar.getInstance().getTimeInMillis();
			user.setCreationDate(new Date(now));
		}
		userRepo.save(user);
	}
	
}
