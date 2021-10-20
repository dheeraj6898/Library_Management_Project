<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Confirmation </title>
</head>
<style>
.container-fluid {
	width: auto;
	background-image: url("static/images/lib6.jpg");
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
</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
      <div class="col-sm-4">
    <div class="card">
      <div class="card-header cardDeco">
          <h3 class="card-title">Detail Confirmation</h3>
      </div>
       
  <div class="card-body cardBodyDeco">
         <h2>Student Detail</h2>
         <img src="download?sid=${student.stu_Id}" class="img-fluid rounded" width="100" alt="photo not load"> <br> 
         <b>Student Id :</b> ${student.stu_Id} <br>
         <b>Student Name :</b> ${student.stu_name} <br>
         <b>Student Contact :</b> ${student.contact} <br>  
          <hr>
          <h2>Book Detail</h2> 
          <b>Book Id :</b>    ${bookDetail.book_id} <br>
          
          <b>Book Name :</b> ${bookDetail.book_name} <br>
          <b>Title :</b>  ${bookDetail.book_title} <br>
          <b>Subject :</b> ${bookDetail.bookSubject.book_sub_name} <br>
      </div>
      <div class="card-footer cardDeco">
        
        <div class="divFloat">
            <form action="bookIssued">
                <input type="hidden" name="stuId" value="${student.stu_Id}">
                <input type="hidden" name="bookId" value="${bookDetail.book_id}">
                <button type="submit" class="btn btn-success">Confirm</button>
              </form>
        </div>

         <div class="divFloat">
            <form action="bookIssueForm">
                <button type="submit" class="btn btn-danger">Cancel</button>
              </form>
         </div>
            
      </div>
       
  </div>
</div>
</div>
</div>

    
   
</body>
</html>