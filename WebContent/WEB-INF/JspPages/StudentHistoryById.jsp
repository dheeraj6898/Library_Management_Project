<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student History</title>
</head>
<style>
.container-fluid {
	width: auto;
	background-image: url("static/images/lib9.jpg");
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
	margin-top: 50px;
	margin-bottom: 50px;
	margin-right: auto;
	margin-left: auto;
}

.col-sm{
	margin-top: 50px;
	margin-bottom: 50px;
	margin-right: auto;
	margin-left: auto;
}

#tableHead {
	background-color: black;
	color: white;
}
</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<c:if test="${not empty student }">
	<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4">
					<div class="card">
						<div class="card-header cardDeco">
							<h3 class="card-title">Student History</h3>
						</div>

						<div class="card-body cardBodyDeco">
							<img src="download?sid=${student.stu_Id}" class="img-fluid rounded" width="100" alt="photo not load">
	
						<br>
						 <b>Student Id : </b>${student.stu_Id}
						<br>
						<b> Name : </b>${student.stu_name}
						<br>
						 <b>Contact : </b>${student.contact}
						<br>
						</div>
					</div>
					</div>
					</div>
	
	<c:if test="${not empty bookIssued}">
		<c:if test="${student.total_bookIssue!=0}">
		<div class="row">
					<div class="col-sm">
						<div class="card">
							<div class="card-header cardDeco">
								<h3 class="card-title">Books Issued By ${student.stu_name}</h3>
							</div>

							<div class="card-body cardBodyDeco">

							<table class="table table-striped table-secondary table-hover">
							    <thead id="tableHead">
  								<tr>
									<th>Book Issued Id</th>
									<th>Book Id</th>
									<th>Book Name</th>
									<th>Book Title</th>
									<th>Book Subject</th>
									<th>Issued Date</th>
									<th>Last Return Date</th>
									<th>Return</th>
								</tr>
								</thead>
							<tbody>
		<c:forEach items="${bookIssued}" var="issued">
			<c:if test="${issued.return_status==0}">
				<tr>
					<td>${issued.bookIssued_id}</td>
					<td>${issued.book_id}</td>
					<td>${issued.book_name}</td>
					<td>${issued.book_title}</td>
					<td>${issued.book_subject}</td>
					<td>${issued.issued_date}</td>
					<td>${issued.last_return_date}</td>
					<td>
						<c:url value="bookReturn" var="returnBook">
							<c:param name="stuId" value="${issued.student_id}"></c:param>
							<c:param name="bookId" value="${issued.book_id}"></c:param>
						</c:url>
						<a href="${returnBook}" class="btn btn-danger">Return Book</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		</tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
		</c:if>
		
		
					<div class="row">
					<div class="col-sm">
						<div class="card">
							<div class="card-header cardDeco">
								<h3 class="card-title">Books Issued/Return by ${student.stu_name}</h3>
							</div>

							<div class="card-body cardBodyDeco">

							<table class="table table-striped table-secondary table-hover">
							    <thead id="tableHead">
  									<tr>
										<th>Book Issued Id</th>
										<th>Book Id</th>
										<th>Book Name</th>
										<th>Book Title</th>
										<th>Book Subject</th>
										<th>Issued Date</th>
										<th>Last Return Date</th>
										<th>Return Date</th>
										<th>Penalty</th>
									</tr>
									</thead>
									<tbody>	
	<c:forEach items="${bookIssued}" var="issued">
		<c:if test="${issued.return_status==1}">
			<tr>
					<td>${issued.bookIssued_id}</td>
					<td>${issued.book_id}</td>
					<td>${issued.book_name}</td>
					<td>${issued.book_title}</td>
					<td>${issued.book_subject}</td>
					<td>${issued.issued_date}</td>
					<td>${issued.last_return_date}</td>
					<td>${issued.return_date}</td>
					<td>${issued.penalty}</td>
				</tr>
		</c:if>
	</c:forEach>
	</tbody>
	</table>
	</div>
	</div>
	</div>
	</div>
	
	</c:if>
	</div>
	
</c:if>

</body>
</html>