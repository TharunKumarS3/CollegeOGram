package com.CollgeOG.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.CollegeOG.model.NewUser;
import com.CollegeOGDAO.NewUserDao;
import com.CollegeOGDAO.UserDao;
import com.CollgeOG.connection.DBconn;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/ruser-login")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			String email=request.getParameter("rLogin-email");
			String pass=request.getParameter("rLogin-password");
			String cpass=request.getParameter("rcLogin-password");
			String name=request.getParameter("rname");
			String dept=request.getParameter("rdept");
			String img=request.getParameter("rimg");
			if(!pass.equals(cpass))
			{
				response.sendRedirect("Register.jsp");
			}
			else
			{

				NewUserDao ndao=new NewUserDao(DBconn.getConnection());
				NewUser nu=ndao.newUser(name, dept, img, email, pass);
				if(nu==null)
				{
					response.sendRedirect("Register.jsp");
				}
				else
				{
					response.sendRedirect("login.jsp");
				}
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
