package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.exception.UserNotFoundException;
import com.foodbox.model.User;
import com.foodbox.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userrepo;
	
	public User addUser(User user) {        
        return userrepo.save(user);
    }
	
	public List<User> findAllUsers(){
		return userrepo.findAll();
	}
	
	public User updateUser(User user) {
		return userrepo.save(user);
	}
	
	public User updateUser(User user, Long id) {
		if(user.getId() == id)
			return userrepo.save(user);
		return user;
	}		
	
	public User findUserById(Long id) {
		return userrepo.findUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}
	
	public void deleteUser(Long id) {
		userrepo.deleteUserById(id);
	}
	

}
