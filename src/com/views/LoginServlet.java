package com.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.daoimpl.UserDaoImpl;
import com.modals.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.write("<!doctype html>");
		pw.write("<html lang='en'>");
		pw.write(" <head>");
		pw.write("<meta charset='utf-8'>");
		pw.write(" <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
		pw.write("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
		pw.write("<title>Login</title>");
		pw.write("</head>");
		pw.write(" <body>");
		
		pw.write("<div class='container'>");
		pw.write("<nav class='navbar navbar-expand-lg navbar-primary bg-primary'>");
		pw.write("<a class='navbar-brand' href='#' style='color:white; font-weight:bold;'>Onlinia</a>");
		pw.write("<button class='navbar-toggler btn-light' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>");
		pw.write("<span class='navbar-toggler-icon'></span>");
		pw.write("</button>");
		pw.write("<div class='collapse navbar-collapse' id='navbarSupportedContent'>");
		pw.write("<ul class='navbar-nav mr-auto'>");
		pw.write("<li class='nav-item active'>");
		pw.write("<a class='nav-link' style='color:white; font-weight:bold;' href='HomeServlet'>Home <span class='sr-only'>(current)</span></a>");
		pw.write("</li>");
		pw.write("<li class='nav-item'>");
		pw.write("<a class='nav-link' style='color:white; font-weight:bold;' href='AddPostServlet'>Add Post</a>");
		pw.write("</li>");
		pw.write(" <li class='nav-item dropdown'>");
		pw.write("<a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false' style='color:white; font-weight:bold;'> Profile </a>");
		pw.write("<div class='dropdown-menu' aria-labelledby='navbarDropdown'>");
		pw.write("<a class='dropdown-item' href='MyProfileServlet'>My Profile</a>");
		pw.write("<a class='dropdown-item' href='ActivityServlet'>Activity</a>");
		pw.write("<div class='dropdown-divider'></div>");
		pw.write("<a class='dropdown-item' href='LogOutServlet'>Logout</a>");
		pw.write("</div>");
		pw.write("</ul>");
		pw.write("<form class='form-inline my-2 my-lg-0'>");
		pw.write(" <input class='form-control mr-sm-2' type='search' placeholder='Search' aria-label='Search'>");
		pw.write(" <button class='btn btn-outline-light my-2 my-sm-0' type='submit'>Search</button>");
		pw.write("</form>");
		pw.write("</div>");
		pw.write("</nav>");
		
		// Content
		pw.write("<div class='container'");
		pw.write("<div class='w-100 p-3 h-100' style='display:flex; justify-content:center; align-items: center;'>");
		
		pw.write("<div style='display: inline-block; width:50%; height:100%; border: 2px solid #d0c9c9; padding: 20px; border-radius: 5px; margin-top: 100px;'>");
		
		
		pw.write("<h1 class='text-center' style='color: #007bff!important'>Login</h1>");
		
		pw.write("<form style='display:inline-block; width:100%;'>");
		pw.write(" <div class='form-group'>");
		pw.write("<label for='exampleInputEmail1' style='color:white;'>Email address</label>");
		pw.write("<input type='email' name='email' class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Enter email'>");
		pw.write("<small id='emailHelp' class='form-text text-muted' style='color:white;'>We'll never share your email with anyone else.</small>");
		pw.write("</div>");
		pw.write(" <div class='form-group'>");
		pw.write(" <label for='exampleInputPassword1' style='color:white;'>Password</label>");
		pw.write("<input type='password' name='password' class='form-control' id='exampleInputPassword1' placeholder='Password'>");
		pw.write("</div>");
		pw.write("<div class='text-center'>");
		pw.write(" <button type='submit' class='btn btn-primary' style='color:white; width: 100px;'>Login</button>");
		pw.write("</div>");
		pw.write("<div class='text-center my-5'>");
		pw.write(" <a href='RegisterServlet' class='btn btn-primary' style='color:white;'>Don't have an account? Register here.</a>");
		pw.write("</div>");
		pw.write("</form>");
		pw.write("<div>");
		
		
		pw.write("</div>");
		pw.write("</div>");
		pw.write("</div>");
		
		pw.write("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
		pw.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
		pw.write("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
		pw.write("</body>");
		pw.write("</html>");
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> allUser = userDaoImpl.getAllUser();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		if (email != null && pass != null) {
			
		
		for(User u:allUser) {
			if (u.getUserEmail().equalsIgnoreCase(email) && u.getUserPassword().equals(pass)) {
				  HttpSession session=request.getSession();  
				  session.setAttribute("user", u);
				  
				response.sendRedirect("HomeServlet");
			}else {
				continue;
			}
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
