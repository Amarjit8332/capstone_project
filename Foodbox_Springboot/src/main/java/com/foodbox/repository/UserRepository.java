package com.foodbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.User;
@Repository
public interface UserRepository   extends JpaRepository<User, Long>{
void deleteUserById(Long id);
	
	Optional<User> findUserById(Long id);

}
