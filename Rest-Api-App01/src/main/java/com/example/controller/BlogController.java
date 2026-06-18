package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Post;
import com.example.service.PostService;

@RestController
public class BlogController {

	@Autowired
	private PostService service;

	@PostMapping("/savepost")
	public Post createPost(@RequestBody Post post) {
		
		return service.createPost(post);
		
	}
	
	
	@GetMapping("/getall")
	public List<Post>getAllPosts(){
		 
		return service.getAllPosts();
	}
	
	
	@GetMapping(value="/getpost/{id}",produces = {"application/json", "application/xml"})
	public Post getPost(@PathVariable int id) {
		
		return service.getPostById(id);
		
	}
}
