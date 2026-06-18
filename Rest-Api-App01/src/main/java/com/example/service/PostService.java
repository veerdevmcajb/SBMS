package com.example.service;

import java.util.List;

import com.example.entity.Post;

public interface PostService {

	Post createPost(Post post);
	
	List<Post>getAllPosts();
	
	Post getPostById(int id);
	
	
}
