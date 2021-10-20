<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="static/bs/css/bootstrap.min.css">
<script src='static/bs/js/jquery-3.2.1.slim.min.js'></script>
<script src='static/bs/js/bootstrap.min.js'></script>

<title>Admin Login Page</title>
<style>
.container-fluid {
	
	width: auto;
	background-image: url("static/images/lib3.jpg");
	background-color: #a6ff9e;
}

#projectName {
	height: 100px;
	width: auto;
	/* background-image:url("static/images/lib1.jpg"); */
	background-color: rgb(186, 176, 197);
}

#lms {
	margin: auto;
}

.col-sm-3 {
	margin-top: 100px;
	margin-bottom: 100px;
	margin-right: auto;
	margin-left: auto;
}

.cardDeco {
	background-color: rgb(186, 176, 197);
}

.cardBodyDeco {
	background-color: rgb(231, 218, 245);
}

#sign {
	color: rgb(36, 20, 248);
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="projectName">
			<h1 id="lms">Library Management System</h1>
		</div>
		
		<div class="row">
			<div class="col-sm-3">
				<div class="card">
					<div class="card-header cardDeco">
						<h5 class="card-title">Login</h5>
					</div>
					<div class="card-body cardBodyDeco">
						<form action="checkLogin" method="post">
							<div class="form-group">
								<label for="username">Email address</label> <input type="text"
									name="username" class="form-control" id="username"
									placeholder="Enter email" aria-describedby="invalid"> 
									<small id="invalid" class="form-text text-muted">${invalid}</small>
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									name="password" class="form-control" id="password"
									placeholder="Password">
							</div>

							<button type="submit" class="btn btn-secondary">Submit</button>
						</form>
					</div>
					<div class="card-footer cardDeco">
						<a href="adminSignUp" class="btn btn-primary"> Sign up</a>
					</div>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>