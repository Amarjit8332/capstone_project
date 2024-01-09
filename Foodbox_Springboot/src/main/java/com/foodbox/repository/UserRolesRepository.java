package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.UserRoles;
@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{


}
