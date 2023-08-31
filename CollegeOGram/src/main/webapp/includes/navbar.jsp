<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">CollegeOGram</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">

				<%
				if (auth == null) {
				%>
				<li class="nav-item"><a class="nav-link" href="Register.jsp">Register</a>
				</li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>

				<%
				} else {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home </a></li>
				<li class="nav-item"><a class="nav-link" href="FriendsList.jsp">FriendsList<span
						class="badge badge-danger px-1">${f_list.size() }</span></a></li>

				<li class="nav-item"><a class="nav-link" href="Logout">LogOut</a>
				</li>

				<%
				}
				%>


			</ul>
		</div>
	</div>
</nav>