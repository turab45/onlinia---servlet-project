package com.views;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoimpl.PostDaoImpl;
import com.daoimpl.UserDaoImpl;
import com.modals.Post;
import com.modals.User;

/**
 * Servlet implementation class AddNewPostLogicServlet
 */
@WebServlet("/AddNewPostLogicServlet")
public class AddNewPostLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPostLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		PostDaoImpl postDaoImpl = new PostDaoImpl();
		
		
		System.out.println("username by session: "+user.getUserName());
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		Integer userId = userDaoImpl.getUserIdByName(user.getUserName());
		System.out.println("User id by database: "+userId);
		User u = userDaoImpl.getUserById(userId);
		
		String postContent = request.getParameter("post-content");
		
		Post post = new Post();
		
		post.setPostContent(postContent);
		post.setPostAuthor(u);
		post.setPostCreateTime(LocalTime.now());
		
		System.out.println(postContent);
		
		
		int result = postDaoImpl.addPost(post);
		
		if(result > 0) {
			response.sendRedirect("HomeServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
