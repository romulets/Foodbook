package com.foodbook.services;

import java.awt.image.BufferedImage;
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
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.helpers.ImageCropperHelper;
import com.foodbook.models.User;
import com.foodbook.modelviews.edituser.EditUserBasicForm;
import com.foodbook.modelviews.edituser.EditUserEmailForm;
import com.foodbook.modelviews.edituser.EditUserPasswordForm;
import com.foodbook.repositories.AddressRepository;
import com.foodbook.repositories.Repository;
import com.foodbook.repositories.UserRepository;
import com.foodbook.storage.ServerPath;
import com.foodbook.storage.StorageService;

@Service
@Primary
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private HashConvertorService convertService;
	
	@Autowired
	private ImageCropperHelper cropper;
	
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
	public void insert(User user) {
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
	public void insert(User user, MultipartFile photo) {
		insert(user);
		saveImage(user, photo);
	}
	
	private void saveImage(User user, MultipartFile photo) {
		String filename;
		if(photo != null && !photo.isEmpty()) {
			filename = String.format("%d_%s", user.getIdUser(), user.getUsername());
			BufferedImage bfImage = cropper.cropCenter(photo);
			filename = storageService.store(bfImage, convertService.convert(filename), ServerPath.USER);
			user.setPhoto(filename);
			update(user);	
		}
	}
	
	@Override
	@Transactional
	public void update(EditUserBasicForm form, int id) {
		User user = userRepo.findById(id);
		update(form, user);		
	}
	
	@Override
	@Transactional
	public void update(EditUserBasicForm form, MultipartFile photo, int id) {
		User user = userRepo.findById(id);
		saveImage(user, photo);
		update(form, user);
	}
	
	private void update(EditUserBasicForm form, User user) {
		user.setName(form.getName());
		
		if(user.getAddress() != null) {
			user.getAddress().setCity(form.getAddress().getCity());
			user.getAddress().setState(form.getAddress().getState());
			user.getAddress().setCountry(form.getAddress().getCountry());
		} else {
			user.setAddress(user.getAddress());
		}
		
		userRepo.save(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}
	
	@Override
	@Transactional
	public void update(EditUserEmailForm form, int id) {
		User user = userRepo.findById(id);
		user.setLogin(form.getEmail());		
		userRepo.save(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}
	
	@Override
	@Transactional
	public void update(EditUserPasswordForm form, int id) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(form.getPassword());
		
		User user = userRepo.findById(id);
		user.setPassword(cryptedPassword);
		userRepo.save(user);
	}
	
	@Override
	@Transactional
	public void update(User user) {
		userRepo.save(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}
