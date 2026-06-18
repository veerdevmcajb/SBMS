package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Post;
import com.example.service.PostService;

@Service
public class PostServiceImpl implements PostService
{
	private List<Post> posts = new ArrayList();
	
	@Override
	public Post createPost(Post post) {
		posts.add(post);
		
		return post;
	}

	
	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return posts;
	}


	@Override
	public Post getPostById(int id) {
		
		for(Post post:posts) {
			
			if(post.getId()==id) {
				return post;
			}
		}
		return null;
	}

	
}
