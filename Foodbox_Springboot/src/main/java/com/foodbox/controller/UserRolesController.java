package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.model.UserRoles;
import com.foodbox.service.UserRolesService;

@RequestMapping(path="/userRoles")
@RestController
@CrossOrigin(origins="*")
public class UserRolesController {
	@Autowired
	private UserRolesService userroleserv;
	
	@GetMapping(path="/all")
	public ResponseEntity<List<UserRoles>> getAllUserRoles(){
		List<UserRoles> roles = userroleserv.findAllUserRoles();		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

}
