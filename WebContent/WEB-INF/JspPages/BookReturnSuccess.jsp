<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Return Success</title>
</head>
<style>
.container-fluid {
	width: auto;
	background-image: url("static/images/lib6.jpg");
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
</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
      <div class="col-sm-4">
    <div class="card">
      <div class="card-header cardDeco">
          <h3 class="card-title">Book Return Successfully</h3>
      </div>
       
  <div class="card-body cardBodyDeco">
						
					<b>Book Return ID : </b>	 ${bookReturn.bookIssued_id} <br>
					<b>	Book Issued Date : </b> ${bookReturn.issued_date} <br>
					<b>	Book last Return Date : </b> ${bookReturn.last_return_date} <br>
					<b>	Book Return Date : </b> ${bookReturn.return_date} <br>
					<b>	Book Return Status : </b> ${bookReturn.return_status} <br>
					<b>	Penalty : </b> ${bookReturn.penalty} <br>
						<hr>
						<b>Student ID : </b> ${bookReturn.student_id}<br>
         <b>Student Name : </b> ${bookReturn.student_name} <br>
         <b>Student Contact : </b>  ${bookReturn.student_contact} <br>  
          <hr>
         
        	 <b> Book ID : </b>${bookReturn.book_id}<br>
			<b>Book Name : </b>${bookReturn.book_name}  <br>
			<b>Book Title : </b>${bookReturn.book_title}<br>
			<b>Book Subject : </b>${bookReturn.book_subject}  <br>
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

