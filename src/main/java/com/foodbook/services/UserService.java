package com.foodbook.services;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.models.User;
import com.foodbook.modelviews.edituser.EditUserBasicForm;
import com.foodbook.modelviews.edituser.EditUserEmailForm;
import com.foodbook.modelviews.edituser.EditUserPasswordForm;
import com.foodbook.repositories.UserRepository;

public interface UserService {
	
	public void insert(User user);
	public void insert(User user, MultipartFile photo);
	
	public void update(EditUserBasicForm form, int id);
	public void update(EditUserBasicForm form, MultipartFile photo, int id);
	public void update(EditUserEmailForm form, int id);
	public void update(EditUserPasswordForm form, int id);
	public void update(User user);
	
	public boolean follow(User user, Authentication auth);
	
	public boolean unfollow(User user, Authentication auth);
	
	public UserRepository getRepository();

}
