package com.modals;

import java.util.Date;
import java.time.LocalTime;

public class Comment {

	Integer commentId;
	String commentContent;
	Post commentPost;
	User commentAuthor;
	LocalTime commentTime;
	Date commentCreateDate;
	
	
	
	public Date getCommentCreateDate() {
		return commentCreateDate;
	}
	public void setCommentCreateDate(Date commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Post getCommentPost() {
		return commentPost;
	}
	public void setCommentPost(Post commentPost) {
		this.commentPost = commentPost;
	}
	public User getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(User commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public LocalTime getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(LocalTime commentTime) {
		this.commentTime = commentTime;
	}
	
	
}
