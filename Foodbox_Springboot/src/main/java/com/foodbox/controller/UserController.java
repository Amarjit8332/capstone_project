package com.foodbox.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.model.User;
import com.foodbox.service.UserService;

@RequestMapping(path="/users")
@RestController
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	private UserService userserv;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userserv.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userserv.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }	
	
	@PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = user;
		newUser.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
		userserv.addUser(newUser);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//you have to send all fields, as PUT updates the entire resource
	@PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id){
		System.out.println("User Passed In:\n" + user.toString());
		System.out.println("Id Passed In:" + id);
		User updateUser = userserv.updateUser(user);		
		System.out.println("Updated User: " + updateUser.toString());
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
		
	@DeleteMapping("/user/delete/{id}")	
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userserv.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
