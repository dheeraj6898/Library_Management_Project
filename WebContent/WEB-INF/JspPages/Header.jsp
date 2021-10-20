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
<title>Header</title>
</head>

    <style>
        .error {
            color: #ff0000;
        }

        .container-fluid {
            border: black 1px solid;
            width: auto;
            height: auto;
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
    </div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Welcome ${librarian.admin_name}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="goHome">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="newStudentForm">Add Student</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="newBookForm">Add Book</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addSubjectForm">Add Subject</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="bookIssueForm">Book Issue</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="bookReturnForm">Book Return</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="searchBookForm">Search Book</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="searchStudentForm">Search Student</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="logOut">Log Out</a>
              </li>
          </ul>
          
        </div>
      </nav>
              
          </body>
          </html>
       