package com.CollgeOG.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.CollegeOG.model.User;
import com.CollegeOGDAO.UserDao;
import com.CollgeOG.connection.DBconn;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.print("siuuuu");
			String email=request.getParameter("Login-email");
			String password=request.getParameter("Login-password");
			
			//out.print(email);
			
			UserDao dao=new UserDao(DBconn.getConnection());
			User user=dao.userLogin(email, password);
			if(user==null)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("auth", user);
				response.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
