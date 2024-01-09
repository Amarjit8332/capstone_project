package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.Tag;
import com.foodbox.repository.TagsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagsService {
	@Autowired
	private TagsRepository tagsrepo;
	
	public List<Tag> findAllTags() {		
		return tagsrepo.findAll();
	}
	
	public Tag addTags(Tag tag) {
		return tagsrepo.save(tag);
	}	

	public void updateTagProductCount(Tag tag, int newProductCount) {		
		tag.setProductCount(newProductCount);		
	}

	public Tag updateTag(Tag tag) {
		return tagsrepo.save(tag);
	}
	
	public Tag updateTag(Tag tag, Long id) {		
		if(tag.getId() == id)
			return tagsrepo.save(tag);
		return null;
	}

	
	public void deleteTag(Long id) {
		tagsrepo.deleteTagById(id);		
	}

}
