package com.foodbox.controller;

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

import com.foodbox.model.Product;
import com.foodbox.model.Tag;
import com.foodbox.service.ProductService;
import com.foodbox.service.TagsService;

@RequestMapping(path="/tags")
@RestController
@CrossOrigin(origins="*")
public class TagsController {
	@Autowired
	private TagsService tagserv;
	@Autowired
	private ProductService productserv;
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Tag>> getAllTags(){
		List<Tag> currentTags = tagserv.findAllTags();	
		List<Product> products = productserv.findAllProducts();
		int tagCount=0, productCount=0;		
		
		for(Tag t : currentTags) {			
			System.out.println("Tag Id: " + t.getId() + ", Tag Name = " + t.getTagName());
			System.out.println("------------------------------------");
			
			if(t.getTagName().toLowerCase().equals("all")) {
				System.out.println("setting count of all products");
				productCount = productserv.findAllProducts().size();				
				tagserv.updateTagProductCount(t, productCount);
			}
			else {						
				 for(Product p : products) {                
		                for (String tag : p.getTags()) {  // Use getTags() directly as it returns a Set<String>
		                    if (tag.equals(t.getTagName())) {
		                        System.out.println("\tProduct " + p.getId() + " - " + p.getProductName());
		                        tagCount++;
						}//end if
					}//product tags
				}//end products
				System.out.println("\tSetting Tag Id: " + t.getId() + "'s productCount to " + tagCount);			
				tagserv.updateTagProductCount(t, tagCount);
				System.out.println("\tresetting tagCount");
				tagCount=0;
			}//end else
		}//end Tag
		
		return new ResponseEntity<>(currentTags, HttpStatus.OK);
	}
	
	/* Method to update Tag stored in the database */
	@PutMapping("/tag/update/{id}")
	public ResponseEntity<Tag> updateTagProductCount(@RequestBody Tag tag, @PathVariable("id") Long id) {
		System.out.println("Tag Passed In:\n" + tag.toString());
		System.out.println("Id Passed In:" + id);
		Tag updatedTag = tagserv.updateTag(tag);
		return new ResponseEntity<>(updatedTag, HttpStatus.OK);
	}
		
	@PostMapping(path="/add")
    public ResponseEntity<Tag> addTags(@RequestBody Tag tag){
		Tag newTag = tag;
		tagserv.addTags(newTag);
		return new ResponseEntity<>(newTag, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cuisine/delete/{id}")	
    public ResponseEntity<?> deleteTag(@PathVariable("id") Long id){
		tagserv.deleteTag(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
