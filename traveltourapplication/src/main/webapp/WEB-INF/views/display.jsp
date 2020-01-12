<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#a{text-align:center;
color:blue;
}
body{
 background: url(http://www.goodmorningimagesforlover.com/wp-content/uploads/2018/09/oxford-images.jpg);
  background-repeat: no-repeat;
  background-size:100%;
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
<title  class="text-primary">Display Booking Details</title>
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
<body class="cus">
  <h1 style="text-align:center;"  class="text-primary">Display Booking Details</h1>
  <hr>
  <div class="container">
    <form action="/displayBooking" method="get">
      <div class="form-group">
     <h3> <label for="phoneNumber"  class="text-primary">Select User:</label></h3>
      <select class="form-control" id="phoneNumber" name="phoneNumber">
             <option selected="selected">Select</option>
        <c:forEach items="${users}" var="user">
            <option value="${user.getPhoneNumber()}">${user.getUserName()}</option>
        </c:forEach>
      </select>
      </div>
      <br>
     <div class="form-group">
       <h3> <label for="dateOfJourney"  class="text-primary">From Date:</label></h3>
          <input type="date" id="dateOfJourney" name="dateOfJourney" class="form-control" placeholder="Enter Date Of Journey">
        </div>
        <br>
        <button type="submit"   class="btn btn-info btn-lg" style="text-align:center;"><span class="glyphicon glyphicon-log-in"></span> Display</button>
    </form>
  </div>
  <br><br>
   <div class="container">
  <form action="/">
     <div class="form-group"> 
        <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>User Name</th>
        <th>Travelling to</th>
        <th>From</th>
         <th>Price</th>
         <th>update</th>
      </tr>
    </thead>
          <c:forEach var ="booking" items = "${bookings}">
              <tbody>
                <tr> 
                    <td><c:out value="${booking.getUser().getUserName()}"/></td>
                     <td><c:out value="${booking.getDestination()}"/></td>
                     <td><c:out value="${booking.getSource()}"/></td>
                     <td><c:out value="${booking.getBookingPrice()}"/></td>
                      <td><a href="http://localhost:8086/update?bookingId=${booking.getBookingId()}" class="btn btn-info" role="button">Update</a></td>
                </tr>
              </tbody>
           </c:forEach> 
  </table>  
  <br><br>
        </div>
         <button type="submit"   class="btn btn-info btn-lg"><span class="glyphicon glyphicon-log-in" onmouseover="this.style.backgroundColor='red';return true;"></span> HomePage</button> 
    </form>
  </div>
</body>
</html> 