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
<script src='static/bs/js/popper.min.js'></script>
<title>Student Form</title>
</head>
<style>

.error {
	color: #ff0000;
}
 .container-fluid {
           
           
            background-image: url("static/images/lib4.jpg");
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
<body>
<jsp:include page="Header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">
      <div class="col-sm-4">
          <div class="card">
              <div class="card-header cardDeco">
                  <h3 class="card-title">Student Registration Form </h3> ${error}
              </div>
              <form:form action="studentRegistration" modelAttribute="student" method="post" enctype="multipart/form-data">
	
              <div class="card-body cardBodyDeco">
                 
                 	<div class="form-group">
                          <label for="photo">Student Photo</label>
                          <input type="file" name="studentFile" class="form-control-file" id="photo">
							<form:errors path="studentFile" cssClass="error"/>
                          
                      </div>
                      <div class="form-group">
                          <label for="name">Name</label>
                          <form:input path="stu_name" class="form-control" id="name" />
                          <form:errors path="stu_name" cssClass="error" />
                      </div>
                      <div class="form-group">
                          <label for="contact">Contact</label>
                          <form:input path="contact" class="form-control" id="contact" />
                          <form:errors path="contact" cssClass="error" />

                      </div>
                      <div class="form-group">
                         <div class="radio">
                         	<label for="gender">Gender</label>
                         </div>
                          <div class="radio">
                          		 Male : <form:radiobutton path="gender" value="male"/>
							Female : <form:radiobutton path="gender" value="female"/>
					
                         </div>
                          
                         
                      </div>
                      <div class="form-group">
                          <label for="building">Building</label>
                         <form:input path="address.building" class="form-control" id="building"/>
						<form:errors path="address.building" cssClass="error"/>
                      </div>
                      <div class="form-group">
                          <label for="colony">Colony</label>
                          <form:input path="address.colony" class="form-control" id="colony"/>
					<form:errors path="address.colony" cssClass="error"/>
                      </div>
                      <div class="form-group">
                          <label for="city">City</label>
                          <form:input path="address.city" class="form-control" id="city" />
                          <form:errors path="address.city" cssClass="error" />
                      </div>
                      <div class="form-group">
                          <label for="pincode">Pincode</label>
                          <form:input path="address.pincode" class="form-control" id="pincode" />
                          <form:errors path="address.pincode" cssClass="error" />
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