package com.CollgeOG.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.CollegeOG.model.FriendList;

/**
 * Servlet implementation class RemoveFriend
 */
@WebServlet("/remove")
public class RemoveFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			//out.print("biii");
			if(!name.equals(null))
			{
			//	out.print("biii8888");
				
				ArrayList<FriendList> flist=(ArrayList<FriendList>)request.getSession().getAttribute("friendList");
				
				
				if(flist!=null)
				{
					for(FriendList f:flist)
					{
						if(f.getName().equals(name))
						{
							flist.remove(flist.indexOf(f));
					//		out.print("biii");
							break;
							
						}
					}
					response.sendRedirect("FriendsList.jsp");
				}
			
			
			}
			else
			{
				response.sendRedirect("FriendsList.jsp");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
