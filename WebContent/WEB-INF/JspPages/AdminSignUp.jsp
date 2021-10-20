<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<title>Admin Sign up</title>
</head>
   <style>
        .error {
            color: #ff0000;
        }

        .container-fluid {
            border: black 1px solid;
            width: auto;
            height: auto;
            background-image: url("static/images/lib1.jpg");
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

        .col-sm-3 {
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
    <div class="container-fluid">
        <div class="row" id="projectName">
            <h1 id="lms">Library Management System</h1>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-header cardDeco">
                        <h5 class="card-title">SignUp</h5>
                    </div>
                    <div class="card-body cardBodyDeco">
                        <form:form action="adminSaved" method="post" modelAttribute="admin">

                            <div class="form-group">
                                <label for="name">Name</label>
                                <form:input path="admin_name" class="form-control" id="name" />
                                <form:errors path="admin_name" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="username">Username</label>
                                <form:input path="username" class="form-control" id="username" />
                                <form:errors path="username" cssClass="error" />

                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <form:input path="password" class="form-control" id="password" />
                                <form:errors path="password" cssClass="error" />

                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <form:input path="emailId" class="form-control" id="email" />
                                <form:errors path="emailId" cssClass="error" />
                            </div>
                            <div class="form-group">
                                <label for="mobile">Contact</label>
                                <form:input path="mobile" class="form-control" id="mobile" />
                                <form:errors path="mobile" cssClass="error" />
                            </div>
                            <button type="submit" class="btn btn-secondary">Submit</button>
                        </form:form>
                    </div>
                    <div class="card-footer cardDeco">
                        <a href="adminLogin" class="btn btn-primary">Login</a>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>

</html>