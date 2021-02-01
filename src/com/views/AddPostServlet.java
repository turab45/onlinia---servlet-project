package com.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modals.User;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
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
		pw.write("<title>Add New Post</title>");
		pw.write("</head>");
		pw.write("<body>");
		
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
		
		// add post content
		pw.write("<div class='container'>");
		
		pw.write("<div style='width:50%; margin: 50px 170px; padding: 26px;border: 1px solid #f1ecec;'>");
		pw.write("<h1 class='text-center' style='color: #007bff!important'>Add New Post</h1>");
		pw.write("<form action='AddNewPostLogicServlet' method='post'>");
		pw.write("<div class='form-group'>");
		pw.write("<label for='exampleFormControlTextarea1'>Write Post.</label>");
		pw.write("<textarea class='form-control' name='post-content' id='exampleFormControlTextarea1' rows='3'></textarea>");
		pw.write("</div>");
		pw.write("<button type='submit' class='btn btn-primary class='margin-top:5px''>Post</button>");
		pw.write("</form>");
		pw.write("</div>");
		
		pw.write("</div>");
		
		pw.write("</div>");
		
		
		pw.write("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
		pw.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
		pw.write("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
		pw.write("</body>");
		pw.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
