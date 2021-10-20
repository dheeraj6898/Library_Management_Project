<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Subject</title>
</head>
<style>

.error {
	color: #ff0000;
}
.container-fluid {
	
	width: auto;
	background-image: url("static/images/lib7.jpg");
	background-color: rgb(238, 243, 166);
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

.col-sm-4 {
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
<body>
<jsp:include page="Header.jsp"></jsp:include>


<div class="container-fluid">
    <div class="row">
      <div class="col-sm-4">
          <div class="card">
              <div class="card-header cardDeco">
                  <h3 class="card-title">Subject Entry</h3>
              </div>
              	<form:form action="addSubject" modelAttribute="subject" method="post">
				<div class="card-body cardBodyDeco">
                 
                 	
                      <div class="form-group">
                          <label for="sName">Subject Name</label>
                          <form:input path="book_sub_name" class="form-control" id="sName" />
                          <form:errors path="book_sub_name" cssClass="error" />

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