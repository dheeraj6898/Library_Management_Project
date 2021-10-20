<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Search Form</title>
</head>
<style>
.container-fluid {
	width: auto;
	background-image: url("static/images/lib10.jpg");
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
                  <h3 class="card-title">Student Search</h3>
              </div>
              	<form action="searchStudent">
					<div class="card-body cardBodyDeco">
                 
                 	
                      <div class="form-group">
                          <label for="sId">Student Id</label>
                          <input type="hidden" name="page" value="1">
						<input type="text" name="sid" placeholder="student id" class="form-control" id="sId">
                         	
                      </div>
                      <div class="form-group">
                          <label for="sname">Student Name</label>
                          <input type="text" name="sname" placeholder="student name" class="form-control" id="sname">
                          
                      </div>
                       <div class="form-group">
                          <label for="scity"> Student City</label>
                          <input type="text" name="scity" placeholder="student city" class="form-control" id="scity">
                          ${error}
                      </div>
                      
              </div>
              <div class="card-footer cardDeco">
                <button type="submit" class="btn btn-secondary">Search</button>
              </div>
               </form>
          </div>
      </div>
  </div>
  

	<c:if test="${not empty studentList}">
		<div class="row">
      <div class="col-sm">
          <div class="card">
              <div class="card-header cardDeco">
                  <h3 class="card-title">Search Results</h3>
              </div>
              <div class="card-body cardBodyDeco">
		<table class="table table-striped table-secondary table-hover">
						    <thead id="tableHead">
						     <tr>
								<th>Student ID</th>
								<th>Profile</th>
								<th>Name</th>
								<th>Contact No.</th>
								<th>Detail</th>
								<th>Remove</th>
								<th>History</th>
							</tr>
						   </thead>
						   <tbody>	
			<c:forEach items="${studentList}" var="sd">
				<tr>
					<td>${sd.stu_Id}</td>
					<td><img src="download?sid=${sd.stu_Id}" class="img-fluid rounded" width="100" alt="photo not load"/></td>
					<td>${sd.stu_name}</td>
					<td>${sd.contact}</td>
					<td>
						<c:url value="studentDetailById" var="detail">
							<c:param name="sid" value="${sd.stu_Id}"></c:param>
						</c:url>
						<a href="${detail}" class="btn btn-success">Detail</a>
					</td>
					<td>
						<c:url value="deleteStudentById" var="remove">
							<c:param name="sid" value="${sd.stu_Id}"></c:param>
						</c:url>
						<a href="${remove}" class="btn btn-danger">Remove</a>
					</td>
					<td>
						<c:url value="studentHistoryById" var="history">
							<c:param name="sid" value="${sd.stu_Id}"></c:param>
						</c:url>
						<a href="${history}" class="btn btn-warning">History</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
			
		</table>
		 </div>
      <div class="card-footer cardDeco">
      	 <ul class="pagination">
      	 	<c:forEach var="i" begin="1" end="${totalPage}">
      	 		<li class="page-item">
      	 			<c:url value="searchStudent" var="page">
							<c:param name="sid" value="${sid}"></c:param>
							<c:param name="sname" value="${sname}"></c:param>
							<c:param name="scity" value="${scity}"></c:param>
							<c:param name="page" value="${i}"></c:param>
					</c:url>

		     <a href="${page}" class="page-link">${i}</a> 

      	 		</li>
      	 	</c:forEach>
      	 </ul>
      </div>
		
	</div>
	</div>
	</div>
		 	
	</c:if>
	</div>
	
</body>
</html>
