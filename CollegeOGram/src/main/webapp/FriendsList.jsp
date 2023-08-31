<%@page import="com.CollgeOG.connection.DBconn"%>
<%@page import="com.CollegeOGDAO.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.CollegeOG.model.*"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
User auth = (User) request.getSession().getAttribute("auth");
if(auth==null)
{
	response.sendRedirect("login.jsp");
}
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<FriendList> flist=(ArrayList<FriendList>) session.getAttribute("friendList");
List<FriendList> fl=null;
if(flist!=null)
{
	StudentDao sdao=new StudentDao(DBconn.getConnection());
	fl=sdao.getFriendList(flist);
	request.setAttribute("f_list",flist);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FriendsList</title>
<%@include file="includes/header.jsp"%>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}
</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>


	<div class="container">
		<table class="table table-Loght">
			<thead>

				<tr>
					<th scope="col">Name</th>
					<th scope="col">Department</th>
					<th scope="col">Action</th>
					<th scope="col">Remove Friend</th>

				</tr>
			</thead>
			<tbody>
			<% 
			
			if(flist!=null)
			{
				for(FriendList fll:fl)
				{%>
					<tr>
					<td><%= fll.getName() %></td>
					<td><%= fll.getDept() %></td>
					<td><a href="#" class="btn btn-dark">Message</a></td>

					<td><a href="remove?name=<%= fll.getName() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

					
				<%}
			}
			
			%>
				


			</tbody>

		</table>

	</div>




	<%@include file="includes/footer.jsp"%>
</body>
</html>