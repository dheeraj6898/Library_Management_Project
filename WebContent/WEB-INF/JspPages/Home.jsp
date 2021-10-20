<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Home Page</title>
<style>
#container{
	 height: 1000px;
     width: auto;
	background-image: url("static/images/lib5.jpg");
	background-color: rgb(238, 243, 166);
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	<div class="container-fluid" id="container">
		<c:if test="${not empty successMessage}">
			<div class="alert alert-info alert-dismissible fade show"
				role="alert">
				<strong>${successMessage}</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		
		<br>
		<h2>Librarian Info</h2>
		
		Id : ${librarian.admin_Id}
		<br>
		 Name : ${librarian.admin_name}
		<br> 
		Username : ${librarian.username}
		<br> 
		Password : ${librarian.password}
		<br> 
		Email : ${librarian.emailId} 
		<br>
		Mobile : ${librarian.mobile} 
		<br> 
		Registerd Date : ${librarian.joinDate}
		<br>
		<hr>
		
		<div>
		A library is a curated collection of sources of information and similar resources, 
		selected by experts and made accessible to a defined community for reference 
		or borrowing, often in a quiet environment  conducive to study. It provides 
		physical or digital access to material, and may be a physical location or a
		 virtual space, or both. A library's collection can include books, periodicals, 
		 newspapers, manuscripts, films, maps, prints, documents, microform, CDs, cassettes,
		  videotapes, DVDs, Blu-ray Discs, e-books, audiobooks, databases, table games, video 
		  games and other formats. Libraries range widely in size up to millions of items. 
		  The word for "library" in many modern languages is derived from Ancient Greek
		   βιβλιοθήκη (bibliothēkē), originally meaning bookcase, via Latin bibliotheca.
		</div>

	</div>


</body>
</html>