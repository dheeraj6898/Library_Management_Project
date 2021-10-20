<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Return</title>
</head>

<style>

.error {
	color: #ff0000;
}
.container-fluid {
	
	width: auto;
	background-image: url("static/images/lib6.jpg");
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
                  <h3 class="card-title">Book Return</h3>
              </div>
              	<form action="bookReturn">
					<div class="card-body cardBodyDeco">
                 
                 	
                      <div class="form-group">
                          <label for="sId">Student Id</label>
                          <input type="text" name="stuId" placeholder="student id" class="form-control" id="sId" required>
						${stuId}
                         
                      </div>
                      <div class="form-group">
                          <label for="bId">Book Id</label>
                          <input type="text" name="bookId" placeholder="book id" class="form-control" id="bId" required>
					${bookId}
                      </div>
                      
              </div>
              <div class="card-footer cardDeco">
                <button type="submit" class="btn btn-secondary">Submit</button>
              </div>
               </form>
          </div>
      </div>
  </div>
  </div>

</body>
</html>



