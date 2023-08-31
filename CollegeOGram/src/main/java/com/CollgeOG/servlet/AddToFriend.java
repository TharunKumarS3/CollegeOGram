package com.CollgeOG.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.CollegeOG.model.FriendList;

/**
 * Servlet implementation class AddToFriend
 */
@WebServlet("/addFriend")
public class AddToFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			ArrayList<FriendList> flist=new ArrayList<>();
			String name=request.getParameter("name");
			//out.print(name);
			FriendList f=new FriendList();
			f.setName(name);
			HttpSession session=request.getSession();
			ArrayList<FriendList> f_list=(ArrayList<FriendList>)session.getAttribute("friendList");
			
			if(f_list==null)
			{
				flist.add(f);
				session.setAttribute("friendList", flist);
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				flist=f_list;
				boolean exist=false;
			//	out.print(flist);
			//	out.print(f_list);
				for(FriendList fi:f_list)
				{
					
					//out.println("siuu"+fi.getName());
					if(fi.getName().equals(name))
					{
						exist=true;
						out.print("<h3 style='color:crimson; text-align:center'>"+fi.getName() +" is already your friend <a href='FriendsList.jsp'>Go to FriendList page</a></h3>");
						
						
					}
					
				}
				if(!exist)
				{
					flist.add(f);
					response.sendRedirect("index.jsp");
				}
			
			}
			for(FriendList fii:f_list)
			{
				out.print(fii.getName());
				
			}
			
		}
		
		
		
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}


}
