<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.CollgeOG.connection.DBconn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.CollegeOG.model.*"%>
<%@ page import="com.CollegeOGDAO.*"%>

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


StudentDao studao=new StudentDao(DBconn.getConnection());
List<Students> students=studao.getAllStudent();

ArrayList<FriendList> flist=(ArrayList<FriendList>) session.getAttribute("friendList");
List<FriendList> fl=null;
if(flist!=null)
{
	
	request.setAttribute("f_list",flist);
}


%>


<!DOCTYPE html>
<html>
<head>
<title>Welcome to CollegeOGram</title>
<%@include file="includes/header.jsp"%>


</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<%@include file="includes/footer.jsp"%>
	<div class="container">

		<div class="card-header my-3">ALL FOLKS IN COG</div>
		<div class="row">
		<%
		if(!students.isEmpty())
		{
			for(Students s:students)
			{%>
				
				<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="StudentImg/<%= s.getImg() %>" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%= s.getName() %></h5>
						<h6 class="dept">Department :<%= s.getDept() %></h6>
						<div class="mt-3 d-flex justify-content-between">
						<a href="addFriend?name=<%=s.getName() %>" class="btn btn-dark">Add Friend</a>
						</div>
						
					</div>
				</div>
			</div>

				
			<%}
		}
		
		
		
		%>
		
		
		
			
		</div>

	</div>

</body>
</html>