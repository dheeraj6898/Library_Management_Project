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
<title>Book Search Form</title>
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
                  <h3 class="card-title">Book Search</h3>
              </div>
              	<form action="searchBook">
					<div class="card-body cardBodyDeco">
                 
                 	
                      <div class="form-group">
                          <label for="bId">Book Id</label>
                          <input type="hidden" name="page" value="1">
						  <input type="text" name="bid" placeholder="book id" class="form-control" id="bId">
						
                      </div>
                      <div class="form-group">
                          <label for="bname">Book Name</label>
                          <input type="text" name="bname" placeholder="book name" class="form-control" id="bname">
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
  

	<c:if test="${not empty books}">
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
								<th>Book ID</th>
								<th>Name</th>
								<th>Title</th>
								<th>Subject</th>
								<th>Detail</th>
								<th>Remove</th>
								<th>History</th>
							</tr>
						   </thead>
						   <tbody>	
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.book_id}</td> 
					<td>${book.book_name}</td>
					<td>${book.book_title}</td>
					<td>${book.bookSubject.book_sub_name}</td>
					<td>
						<c:url value="bookDetailById" var="detail">
							<c:param name="bid" value="${book.book_id}"></c:param>
						</c:url>
						<a href="${detail}" class="btn btn-success">Detail</a>
					</td>
					<td>
						<c:url value="deleteBookById" var="remove">
							<c:param name="bid" value="${book.book_id}"></c:param>
						</c:url>
						<a href="${remove}" class="btn btn-danger">Remove</a>
					</td>
					<td>
						<c:url value="bookHistoryById" var="history">
							<c:param name="bid" value="${book.book_id}"></c:param>
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
      	 			<c:url value="searchBook" var="page">
							<c:param name="bid" value="${bid}"></c:param>
							<c:param name="bname" value="${bname}"></c:param>
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