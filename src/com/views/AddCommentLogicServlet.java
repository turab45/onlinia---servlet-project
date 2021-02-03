package com.views;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommentDAO;
import com.daoimpl.CommentDaoImpl;
import com.daoimpl.PostDaoImpl;
import com.daoimpl.UserDaoImpl;
import com.modals.Comment;
import com.modals.Post;
import com.modals.User;

/**
 * Servlet implementation class AddCommentLogicServlet
 */
@WebServlet("/AddCommentLogicServlet")
public class AddCommentLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentContent = request.getParameter("comment-content");
		
		CommentDAO commentDAOImpl = new CommentDaoImpl();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		System.out.println("AddCommentLogicServlet File");
		System.out.println("Comment content form previous file :"+commentContent);
		System.out.println("User Name "+user.getUserName());
		
		System.out.println("Post id from previous file "+request.getParameter("id"));
		Integer postId = Integer.parseInt(request.getParameter("id"));
		
		
		if (commentContent != null) {
			PostDaoImpl postDaoImpl= new PostDaoImpl();
			
			Post post = postDaoImpl.getPostById(postId);
			
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			Integer userId = userDaoImpl.getUserIdByName(user.getUserName());
			//System.out.println("User id by database: "+userId);
			User u = userDaoImpl.getUserById(userId);
			
			
			Comment comment = new Comment();
			comment.setCommentContent(commentContent);
			comment.setCommentPost(post);
			comment.setCommentAuthor(u);
			comment.setCommentTime(LocalTime.now());
			
			java.util.Date date = new java.util.Date();
			comment.setCommentCreateDate(date);
			
			int result = commentDAOImpl.addComment(comment);
			
			System.out.println("Add Comment result "+result);
			
			if (result > 0) {
				response.sendRedirect("AddCommentServlet?id="+postId);
			}
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
