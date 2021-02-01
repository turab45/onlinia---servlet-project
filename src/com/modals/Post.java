package com.modals;

import java.time.LocalTime;

public class Post {
	Integer postId;
	String postContent;
	User postAuthor;
	LocalTime postCreateTime;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public User getPostAuthor() {
		return postAuthor;
	}
	public void setPostAuthor(User postAuthor) {
		this.postAuthor = postAuthor;
	}
	public LocalTime getPostCreateTime() {
		return postCreateTime;
	}
	public void setPostCreateTime(LocalTime postCreateTime) {
		this.postCreateTime = postCreateTime;
	}
	
	

}
