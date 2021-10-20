<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Detail</title>
</head>
<style>
.container-fluid {
	width: auto;
	background-image: url("static/images/lib8.jpg");
	background-color: rgb(238, 243, 166);
}

.cardDeco {
	background-color: rgb(186, 176, 197);
}

.cardBodyDeco {
	background-color: rgb(231, 218, 245);
}

.divFloat {
	float: left;
}


.col-sm-4 {
	margin-top: 100px;
	margin-bottom: 100px;
	margin-right: auto;
	margin-left: auto;
}

#tableHead{
	background-color: black;
	 color: white;
}
</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
      <div class="col-sm-4">
    <div class="card">
      <div class="card-header cardDeco">
          <h3 class="card-title">Book Information</h3>
      </div>
       
  <div class="card-body cardBodyDeco">
						<b>Book ID : </b>${book.book_id} <br>
						<b>Book Name : </b>${book.book_name} <br>
						<b>Book Title : </b>${book.book_title} <br>
						<b>Language : </b>${book.book_language}<br>
						<b>Description : </b>${book.book_description} <br>
						<b>Price : </b>${book.book_price}<br>
						<b>Registerd Date : </b>${book.book_reg_date} <br>
						<b>Book Available : </b>${book.book_available} <br>
						<hr>
						<h4>Book Publisher</h4>
						<b>Publisher ID : </b> ${book.bookPublisher.publisher_id} <br>
						<b>Publisher Name : </b> ${book.bookPublisher.publisher_name} <br>
						<b>Publisher Address : </b> ${book.bookPublisher.publisher_address} <br>
						<b>Publish Year : </b> ${book.bookPublisher.publisher_year} <br>
						<hr>
						<h4>Book Subject</h4>
						<b>Subject ID : </b> ${book.bookSubject.book_sub_id} <br>
						<b>Subject Name : </b> ${book.bookSubject.book_sub_name} <br>
						<hr>
						<h4>Book Authors</h4>
						
						<table class="table table-striped table-secondary table-hover">
						    <thead id="tableHead">
						      <tr>
						        <th>Author ID</th>
						        <th>Author Name</th>
						      </tr>
						    </thead>
							<tbody>
							  <c:forEach items="${book.bookAuthor}" var="auth">
								<tr>
									<th>${auth.author_id}</th>
									<th>${auth.author_name}</th>
								</tr>
							</c:forEach>
						</tbody>
						</table>
							
      </div>
      <div class="card-footer cardDeco">
      	 <a href="goHome" class="btn btn-success">Home</a>
      </div>
       
  </div>
</div>
</div>
</div>
</body>
</html>
