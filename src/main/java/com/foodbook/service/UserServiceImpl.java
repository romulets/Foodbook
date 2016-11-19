package com.foodbook.service;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodbook.model.User;
import com.foodbook.modelview.EditUserForm;
import com.foodbook.repository.AddressRepository;
import com.foodbook.repository.Repository;
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
	public UserRepository getRepository() {
		return userRepo;
	}
	
	@Override
	public boolean follow(User userToFollow, Authentication auth) {
		User currentUser = (User) auth.getPrincipal();
		currentUser = userRepo.findById(currentUser.getIdUser());
		userToFollow = userRepo.findById(userToFollow.getIdUser());
		
		currentUser.getFollowing().add(userToFollow);
		userToFollow.getFollowers().add(userToFollow);
		userRepo.update(currentUser);
		
		return true;
	}
	
	@Override
	public boolean unfollow(User userToUnfollow, Authentication auth) {
		User currentUser = (User) auth.getPrincipal();
		currentUser = userRepo.findById(currentUser.getIdUser());
		userToUnfollow = userRepo.findById(userToUnfollow.getIdUser());
		
		currentUser.getFollowing().remove(userToUnfollow);
		userToUnfollow.getFollowers().remove(currentUser);
		userRepo.update(currentUser);		
		
		return true;
	}
	
	@Override
	@Transactional
	public void insertUser(User user) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;
		
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(user.getPassword());
		
		user.setPassword(cryptedPassword);
		
		if(user.getAddress() != null) {
			user.getAddress().setUser(user);
			addressRepo.save(user.getAddress());
		}
			
		
		if(user.getCreationDate() == null) {
			long now = GregorianCalendar.getInstance().getTimeInMillis();
			user.setCreationDate(new Date(now));
		}
		userRepo.save(user);
	}
	
	@Override
	@Transactional
	public void editUser(EditUserForm userForm, int id) {
		User user = userRepo.findById(id);
		user.setName(userForm.getName());
		
		if(user.getAddress() != null) {
			user.getAddress().setCity(userForm.getAddress().getCity());
			user.getAddress().setState(userForm.getAddress().getState());
			user.getAddress().setCountry(userForm.getAddress().getCountry());
		} else {
			user.setAddress(user.getAddress());
		}
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
		userRepo.save(user);
	}
	
}
