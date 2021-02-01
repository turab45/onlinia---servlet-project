package com.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDAO;
import com.dbmanager.DBConnection;
import com.modals.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDAO{
	Connection conn = DBConnection.getConnection();

	@Override
	public Integer addUser(User user) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("insert into `user`(username, email, password) values(?,?,?)");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer UpdateUser(User user) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("update `user` set username=?, email=?, password=? where `user-id`=?");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setInt(4, user.getUserId());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteUser(int id) {
		Integer row = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("delete from `user` where `user-id`=?");
			pstmt.setInt(1, id);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select username,email,password from `user` where `user-id`=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				
				user.setUserId(id);
				user.setUserName(rs.getString("username"));
				user.setUserEmail(rs.getString("email"));
				user.setUserPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public Integer getUserIdByName(String userName) {
		Integer userId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select `user-id` from `user` where username=?");
			pstmt.setString(1, userName);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userId = rs.getInt("user-id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
	@Override
	public List<User> getAllUser() {
		List<User> allUser = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from `user`");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				User user = new User();
				
				user.setUserId(rs.getInt("user-id"));
				user.setUserName(rs.getString("username"));
				user.setUserEmail(rs.getString("email"));
				user.setUserPassword(rs.getString("password"));
				
				allUser.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUser;
	}

}
