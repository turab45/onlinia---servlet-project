package com.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.dao.CommentDAO;
import com.dbmanager.DBConnection;
import com.modals.Comment;
import com.modals.Post;
import com.modals.User;
import com.mysql.jdbc.PreparedStatement;

public class CommentDaoImpl implements CommentDAO{

	Connection conn = DBConnection.getConnection();
	
	@Override
	public Integer addComment(Comment comment) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			// convert localtime to sql time
			Time commentCreateTimeSql =  Time.valueOf(comment.getCommentTime());
			
			pstmt = (PreparedStatement) conn.prepareStatement("insert into comments(content,post-id, author-id, create-time) values(?,?,?,?)");
			pstmt.setString(1, comment.getCommentContent());
			pstmt.setInt(2, comment.getCommentPost().getPostId());
			pstmt.setInt(3, comment.getCommentAuthor().getUserId());
			pstmt.setTime(4,commentCreateTimeSql);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer UpdateComment(Comment comment) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			// convert localtime to sql time
			Time commentCreateTimeSql =  Time.valueOf(comment.getCommentTime());
			
			pstmt = (PreparedStatement) conn.prepareStatement("update comments set content=?,post-id=?, author-id=?, create-time=? where comment-id=?");
			pstmt.setString(1, comment.getCommentContent());
			pstmt.setInt(2, comment.getCommentPost().getPostId());
			pstmt.setInt(3, comment.getCommentAuthor().getUserId());
			pstmt.setTime(4,commentCreateTimeSql);
			pstmt.setInt(5, comment.getCommentId());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteComment(int id) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			
			pstmt = (PreparedStatement) conn.prepareStatement("delete from comments where comment-id=?");
			pstmt.setInt(1, id);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Comment getCommentById(int id) {
		Comment comment = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select content,post-id,author-id,create-time from comments where comment-id=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				comment = new Comment();
				
				Post postId = new Post();
				User authorId = new User();
				
				postId.setPostId(rs.getInt("post-id"));
				
				authorId.setUserId(rs.getInt("author-id"));
				
				Time sqlTime = rs.getTime("create-time");
				
				comment.setCommentId(id);
				comment.setCommentContent(rs.getString("content"));
				comment.setCommentAuthor(authorId);
				comment.setCommentPost(postId);
				comment.setCommentTime(sqlTime.toLocalTime());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public List<Comment> getAllComment() {
		List<Comment> allComment = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from comments");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				allComment = new ArrayList<Comment>();
				
				Comment comment = new Comment();
				
				Post postId = new Post();
				User authorId = new User();
				
				postId.setPostId(rs.getInt("post-id"));
				
				authorId.setUserId(rs.getInt("author-id"));
				
				Time sqlTime = rs.getTime("create-time");
				
				comment.setCommentId(rs.getInt("comment-id"));
				comment.setCommentContent(rs.getString("content"));
				comment.setCommentAuthor(authorId);
				comment.setCommentPost(postId);
				comment.setCommentTime(sqlTime.toLocalTime());
				
				allComment.add(comment);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allComment;
	}

	@Override
	public List<Comment> getCommentsOfPost(Post post) {
		List<Comment> allComment = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from comments where post-id=?");
			pstmt.setInt(1, post.getPostId());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				allComment = new ArrayList<Comment>();
				
				Comment comment = new Comment();
				
				Post postId = new Post();
				User authorId = new User();
				
				postId.setPostId(rs.getInt("post-id"));
				
				authorId.setUserId(rs.getInt("author-id"));
				
				Time sqlTime = rs.getTime("create-time");
				
				comment.setCommentId(rs.getInt("comment-id"));
				comment.setCommentContent(rs.getString("content"));
				comment.setCommentAuthor(authorId);
				comment.setCommentPost(postId);
				comment.setCommentTime(sqlTime.toLocalTime());
				
				allComment.add(comment);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allComment;
	}

}
