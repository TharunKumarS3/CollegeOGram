<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.CollegeOG.model.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
	response.sendRedirect("index.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="includes/header.jsp"%>


</head>

<body>
	<%@include file="includes/navbar.jsp"%>
	<%@include file="includes/footer.jsp"%>
	

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Registration</div>
			<div class="card-body">
				<form action="ruser-login" method="post">

					<div class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							name="rLogin-email" placeholder="Enter your Email" required>
					</div>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="rname" placeholder="Enter your Email" required>
					</div>
					
					<div class="form-group">
						<label>Department</label> <input type="text" class="form-control"
							name="rdept" placeholder="Enter your Email" required>
					</div>
					
					<div class="form-group">
						<label>Image</label> <input type="text" class="form-control"
							name="rimg" placeholder="Enter your Email" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="rLogin-password" placeholder="********"
							required>
					</div>
					
						<div class="form-group">
						<label>Confirm Password</label> <input type="password"
							class="form-control" name="rcLogin-password" placeholder="********"
							required>
					</div>

					<div class="text-center">
						<button type="sumbit" class="btn btn-primary">Register</button>
					</div>

				</form>



			</div>

		</div>

	</div>



</body>
</html>