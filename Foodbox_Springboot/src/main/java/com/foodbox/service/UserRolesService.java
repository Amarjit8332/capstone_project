package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.UserRoles;
import com.foodbox.repository.UserRolesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserRolesService {
	@Autowired
	private UserRolesRepository userRolerepo;
	
	public UserRolesService(UserRolesRepository userRolesRepo) {		
		this.userRolerepo = userRolesRepo;
	}

	public List<UserRoles> findAllUserRoles() {		
		return userRolerepo.findAll();
	}

}
