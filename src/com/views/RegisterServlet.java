package com.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoimpl.UserDaoImpl;
import com.modals.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		pw.write("<title>Sign Up - Register Yourself</title>");
		pw.write("</head>");
		pw.write(" <body style='background: rgb(69,149,158); background: linear-gradient(90deg, rgba(69,149,158,1) 13%, rgba(31,55,107,1) 73%);'>");
		
		// Content
		pw.write("<div class='container' style='display:inline-block; margin: 60px 246px;'>");
		pw.write("<div class='w-100 p-3 h-100' style='display:flex; justify-content:center; align-items: center;'>");
		
		pw.write("<div style='display: inline-block; width:50%; height:100%; border: 2px solid white; padding: 50px; border-radius: 5px;'>");
		
		
		pw.write("<h1 class='text-center' style='color:white;'>Sign Up</h1>");
		
		pw.write("<form style='display:inline-block; width:100%;'>");
		pw.write(" <div class='form-group'>");
		pw.write("<label for='exampleInputEmail1' style='color:white;'>Username</label>");
		pw.write("<input type='text' name='username' class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Enter User Name'>");
		pw.write("</div>");
		pw.write(" <div class='form-group'>");
		pw.write("<label for='exampleInputEmail1' style='color:white;'>Email address</label>");
		pw.write("<input type='email' name='email' class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Enter email'>");
		pw.write("<small id='emailHelp' class='text-light'>We'll never share your email with anyone else.</small>");
		pw.write("</div>");
		pw.write(" <div class='form-group'>");
		pw.write(" <label for='exampleInputPassword1' style='color:white;'>Password</label>");
		pw.write("<input type='password' name='password' class='form-control' id='exampleInputPassword1' placeholder='Password'>");
		pw.write("</div>");
		pw.write("<div class='text-center'>");
		pw.write(" <button type='submit' class='btn btn-primary' style='color:white; width: 100px;'>Sign Up</button>");
		pw.write("</div>");
		pw.write("</form>");
		
		
		pw.write("</div>");
		pw.write("</div>");
		pw.write("</div>");
		
		pw.write("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
		pw.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
		pw.write("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
		pw.write("</body>");
		pw.write("</html>");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = null;
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (userName != null && email != null && password != null) {
			System.out.println("User Name: "+userName);
			System.out.println("Email    : "+email);
			System.out.println("Password : "+password);

			user = new User();
			user.setUserName(userName);
			user.setUserEmail(email);
			user.setUserPassword(password);
//			
			int result = userDaoImpl.addUser(user);
			System.out.println("result is "+result);
			if (result > 0) {
				response.sendRedirect("LoginServlet");
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
