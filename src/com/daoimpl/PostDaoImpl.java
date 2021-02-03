package com.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.dao.PostDAO;
import com.dbmanager.DBConnection;
import com.modals.Post;
import com.modals.User;
import com.mysql.jdbc.PreparedStatement;

public class PostDaoImpl implements PostDAO{
	Connection conn = DBConnection.getConnection();

	@Override
	public Integer addPost(Post post) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			// convert localtime to sql time
			Time postCreateTimeSql =  Time.valueOf(post.getPostCreateTime());
			
			Date sqlDate = new Date(post.getPostCreateDate().getTime());
			
			pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO post(content,author,`create-time`,`create-date`) VALUES(?,?,?,?);");
			pstmt.setString(1, post.getPostContent());
			pstmt.setInt(2, post.getPostAuthor().getUserId());
			pstmt.setTime(3,postCreateTimeSql);
			pstmt.setDate(4, sqlDate);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer UpdatePost(Post post) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			// convert localtime to sql time
			Time postCreateTimeSql =  Time.valueOf(post.getPostCreateTime());
			
			Date sqlDate = new Date(post.getPostCreateDate().getTime());
			
			pstmt = (PreparedStatement) conn.prepareStatement("update post set content=?, author=?, `create-time`=?,`create-date`=? where post-id=?");
			pstmt.setString(1, post.getPostContent());
			pstmt.setInt(2, post.getPostAuthor().getUserId());
			pstmt.setTime(3,postCreateTimeSql);
			pstmt.setInt(4, post.getPostId());
			pstmt.setDate(5, sqlDate);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deletePost(int id) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			
			pstmt = (PreparedStatement) conn.prepareStatement("delete from  post where post-id=?");
			pstmt.setInt(1, id);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Post getPostById(int id) {
		Post post = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from `post` where `post-id`=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				post = new Post();
				
				User postAuthor = new User();
				postAuthor.setUserId(rs.getInt("author"));
				
				Time sqlTime = rs.getTime("create-time");
				
				post.setPostId(id);
				post.setPostContent(rs.getString("content"));
				post.setPostAuthor(postAuthor);
				post.setPostCreateTime(sqlTime.toLocalTime());
				post.setPostCreateDate(rs.getDate("create-date"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public List<Post> getAllPost() {
		List<Post> allPost = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from post order by `post-id` desc;");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				
				User postAuthor = new User();
				postAuthor.setUserId(rs.getInt("author"));
				
				Time sqlTime = rs.getTime("create-time");
				
				post.setPostId(rs.getInt("post-id"));
				post.setPostContent(rs.getString("content"));
				post.setPostAuthor(postAuthor);
				post.setPostCreateTime(sqlTime.toLocalTime());
				post.setPostCreateDate(rs.getDate("create-date"));
				
				allPost.add(post);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPost;
	}

	public List<Post> getAllPostsOfAuthor(int id){
		List<Post> allPost = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from post where author=?;");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				
				User postAuthor = new User();
				postAuthor.setUserId(rs.getInt("author"));
				
				Time sqlTime = rs.getTime("create-time");
				
				post.setPostId(rs.getInt("post-id"));
				post.setPostContent(rs.getString("content"));
				post.setPostAuthor(postAuthor);
				post.setPostCreateTime(sqlTime.toLocalTime());
				post.setPostCreateDate(rs.getDate("create-date"));
				
				allPost.add(post);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPost;
	}
	
}
