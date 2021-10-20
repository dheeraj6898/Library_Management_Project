<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Detail</title>
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
          <h3 class="card-title">Student Detail</h3>
      </div>
       
  <div class="card-body cardBodyDeco">
   						<img src="download?sid=${student.stu_Id}" class="img-fluid rounded" width="100" alt="photo not load"> <br> 
						<b>Student Id : </b>${student.stu_Id} <br>
						<b>Name : </b>${student.stu_name} <br>
						<b>Gender : </b>${student.gender} <br>
						<b>Contact : </b>${student.contact} <br>
						<b>Registration Date : </b>${student.regDate} <br>
						<b>Address : </b>${student.address.building}, ${student.address.colony} <br>
						<b>City : </b>${student.address.city} <br>
						<b>Pincode : </b>${student.address.pincode} <br>
						<b>No. of Book Issue : </b>${student.total_bookIssue} <br>
						
							
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
