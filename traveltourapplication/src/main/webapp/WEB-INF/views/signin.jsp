<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
body{
 background: url(https://cdn.wallpapersafari.com/84/58/KWdsAn.jpg);
  background-repeat: no-repeat;
  background-size:100%;
}
.error {
      color: red;
   }
header {
text-align: center;
}
</style>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    $(window).resize(function() {
        if ($(window).width() <= 700) {
            $(".cus").css("background-color", "yellow");
        }
        if ($(window).width() > 700) {
            $(".cus").css("background-color", "rgba(0,0,0,0.5)");
        }
    });
</script>
<title  class="text-primary">Login User</title>
       <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js" integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
        crossorigin="anonymous"></script>
     <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     jQuery library
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    Latest compiled JavaScript
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>
  <h1 style="text-align:center;">Login User</h1>
  <hr>
  <div class="container">
    <form action="/loginUser">
     <div class="form-group">
       <h3> <label for="userName"  class="text-primary">User Name:</label></h3>
          <input type ="text" id="userName" name="userName" class="form-control" placeholder="Enter User Name">
        </div>
        <div class="form-group">
       <h3> <label for="phoneNumber"  class="text-primary">Password:</label></h3>
          <input type="password" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter User Password">
        </div>
        <br><br>
      <button type="submit"   class="btn btn-info btn-lg"><span class="glyphicon glyphicon-log-in"></span> SignIn</button>
    </form>
  </div>
    <script > $('form').validate({
        errorClass: 'errors',
            rules: {
            	userName: {
                    required: true,
                    lettersonly: true,
                    maxlength: 10
                },
                phoneNumber: {
                    required: true,
                    rangelength: [10, 10],
                    number:true
                }
            },
            highlight: function (element) {
                $(element).parent().addClass('error')
            },
            unhighlight: function (element) {
                $(element).parent().removeClass('error')
            }
           /*messages: {
                teacherName: "Please Give Letters Only."
            } */
        });
    </script>
  
</body>
</html>