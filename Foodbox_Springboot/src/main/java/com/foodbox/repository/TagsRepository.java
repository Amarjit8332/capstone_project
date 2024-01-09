package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Tag;
@Repository
public interface TagsRepository extends JpaRepository<Tag, Long>{

	void deleteTagById(Long id);
}
