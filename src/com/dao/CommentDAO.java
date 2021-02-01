package com.dao;

import java.util.List;

import com.modals.Comment;
import com.modals.Post;

public interface CommentDAO {

	public Integer addComment(Comment comment);
	public Integer UpdateComment(Comment comment);
	public Integer deleteComment(int id);
	public Comment getCommentById(int id);
	public List<Comment> getAllComment();
	public List<Comment> getCommentsOfPost(Post post);
}
