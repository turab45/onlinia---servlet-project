package com.dao;

import java.util.List;

import com.modals.Post;

public interface PostDAO {

	public Integer addPost(Post post);
	public Integer UpdatePost(Post post);
	public Integer deletePost(int id);
	public Post getPostById(int id);
	public List<Post> getAllPost();
	public List<Post> getAllPostsOfAuthor(int id);
}
