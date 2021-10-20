<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="static/bs/css/bootstrap.min.css">
<script src='static/bs/js/jquery-3.2.1.slim.min.js'></script>
<script src='static/bs/js/bootstrap.min.js'></script>
<title>Add Book</title>

<style>

.error {
	color: #ff0000;
}
 .container-fluid {
           
           
            background-image: url("static/images/lib2.jpg");
            background-color: rgb(238, 243, 166);  /* if image not show than background color show */
        }

        #projectName {
            height: 100px;
            width: auto;
           
            background-color: rgb(186, 176, 197);
        }

        #lms {
            margin: auto;
        }

        .col-sm-4 {
            margin-top: 50px;
            margin-bottom: 50px;
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
<jsp:include page="Header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">
      <div class="col-sm-4">
          <div class="card">
              <div class="card-header cardDeco">
                  <h3 class="card-title">Book Entry</h3> ${error}
              </div>
              <form:form action="saveBookDetail" modelAttribute="bookDetail" method="post">
              <div class="card-body cardBodyDeco">
                 
                 	<div class="form-group">
                          <label for="name">Book Name</label>
                          <form:input path="book_name" class="form-control" id="name"/>
							<form:errors path="book_name"/>
                      </div>
                      <div class="form-group">
                          <label for="title">Book Title</label>
                          <form:input path="book_title" class="form-control" id="title" />
                          <form:errors path="book_title" cssClass="error" />
                      </div>
                      <div class="form-group">
                          <label for="language">Language</label>
                          <form:input path="book_language" class="form-control" id="language" />
                          <form:errors path="book_language" cssClass="error" />

                      </div>
                      <div class="form-group">
                          <label for="description">Book Description</label>
                         <form:input path="book_description" class="form-control" id="description"/>
						<form:errors path="book_description" cssClass="error"/>
                      </div>
                      <div class="form-group">
                          <label for="price">Price</label>
                          <form:input path="book_price" class="form-control" id="price"/>
					<form:errors path="book_price" cssClass="error"/>
                      </div>
                      <div class="form-group">
                          <label for="subject">Subject</label>
								<form:select path="bookSubject.book_sub_id" class="form-control" id="subject">
									<c:forEach items="${subjectList}" var="e">
										<form:option value="${e.book_sub_id}">${e.book_sub_name}</form:option>
									</c:forEach>
								</form:select>
					  </div>
							<div class="form-group">
								<label for="author">Author Name</label>
								<div id="addInput">
									<form:input path="bookAuthor[0].author_name" class="form-control" id="author"/>
									<form:errors path="bookAuthor[0].author_name" />
								</div>

								<%-- <form:input path="bookAuthor[1].author_name"/> <br>
					 				<form:input path="bookAuthor[2].author_name"/>  --%>
								<!-- 				 <button onclick="createInput(event)">Add More Author</button> 
 -->
								<button id="addAuthorBtn" class="btn btn-success">Add More Author</button>

							</div>

							<div class="form-group">
								<label for="pName">Publisher Name</label>
								<form:input path="bookPublisher.publisher_name" class="form-control" id="pName" />
								<form:errors path="bookPublisher.publisher_name" cssClass="error" />
							</div>
							<div class="form-group">
								<label for="pAddress">Publisher Address</label>
								<form:input path="bookPublisher.publisher_address" class="form-control" id="pAddress" />
								<form:errors path="bookPublisher.publisher_address" cssClass="error" />
							</div>
							<div class="form-group">
								<label for="pYear">Publishe Year</label>
								<form:input path="bookPublisher.publisher_year" class="form-control" id="pYear" />
								<form:errors path="bookPublisher.publisher_year" cssClass="error" />
							</div>

						</div>
              <div class="card-footer cardDeco">
                <button type="submit" class="btn btn-secondary">Submit</button>
              </div>
               </form:form>
          </div>
      </div>
  </div>
  </div>

</body>
</html>





	

<script>
 /*    let addInput=document.getElementById("addInput");
	
    let count=0;    
    function createInput(e){
        e.preventDefault();
        count=count+1;
        let inputCreate='<br><input type="text" name="bookAuthor['+count+'].author_name"/>';
        addInput.innerHTML+=inputCreate;
    }  */
    
    $(document).ready(function(){
    	
	    let count=0;
	    $("#addAuthorBtn").click(function(event){
	    	event.preventDefault();
	    	count=count+1;
	        let inputCreate='<br><input type="text" name="bookAuthor['+count+'].author_name" class="form-control" id="author"/>';
			$("#addInput").append(inputCreate);
	    });
    });
    
</script> 