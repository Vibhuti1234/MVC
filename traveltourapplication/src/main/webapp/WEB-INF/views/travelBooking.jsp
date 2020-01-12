<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
#foodPreference{
color:blue;
}
#travellingWith{
color:blue;}
body{
 background: url(https://cdn.wallpapersafari.com/84/58/KWdsAn.jpg);
  background-repeat: no-repeat;
  background-size:120%;
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

<title  class="text-primary">Add Booking</title>
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
  <h1 style="text-align:center;"  class="text-primary">Add Booking</h1>
  <hr>
  <div class="container">
    <form action="/addBooking" method="post">
      <div class="form-group">
     <h3> <label for="phoneNumber"  class="text-primary">UserName:</label></h3>
      <select class="form-control" id="phoneNumber" name="phoneNumber">
             <option selected="selected">Select</option>
        <c:forEach items="${users}" var="user">
            <option value="${user.getPhoneNumber()}">${user.getUserName()}</option>
        </c:forEach>
      </select>
      </div>
      <br><br>
     <div class="form-group">
        <h3><label for="source"  class="text-primary">Source:</label></h3>
          <input type ="text" id="source" name="source" class="form-control" >
        </div>
         <div class="form-group">
        <h3><label for="destination"  class="text-primary">Destination:</label></h3>
          <input type ="text" id="destination" name="destination" class="form-control" >
        </div>
         <div class="form-group">
        <h3><label for="dateOfJourney"  class="text-primary">DateOfJourney:</label></h3>
          <input type ="date" id="dateOfJourney" name="dateOfJourney" class="form-control" >
        </div>
         <div class="form-group">
        <h3><label for="distance"  class="text-primary">Distance:</label></h3>
          <input type ="number" id="distance" name="distance" class="form-control" min="200" >
        </div>
            <h3 style="color:blue;">Food Preference:</h3>
        <div class="form-check">
      <label class="form-check-label" for="foodPreference">
        <input type="radio" class="form-check-input" id="foodPreference" name="foodPreference" value="Vegeterian">Vegeterian
      </label>
    </div>
    <div class="form-check">
      <label class="form-check-label" for="foodPreference">
        <input type="radio" class="form-check-input" id="foodPreference" name="foodPreference" value="Non-Vegeterian">Non-Vegeterian
      </label>
    </div>
    <h3 style="color:blue;">Travelling With:</h3>
    <div class="form-check-inline">
      <label class="form-check-label" for="travellingWith">
        <input type="checkbox" class="form-check-input" id="travellingWith" name="travellingWith" value="Visa">Visa
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label" for="travellingWith">
        <input type="checkbox" class="form-check-input" id="travellingWith" name="travellingWith" value="Passport">Passport
      </label>
    </div>
       <br>
      <button type="submit"   class="btn btn-info btn-lg"><span class="glyphicon glyphicon-log-in"></span> Book</button>
    </form>
  </div>
  <br><br>
  <!-- <div class="container">
    <form action="/"> 
      <button type="submit"   class="btn btn-info btn-lg" ><span class="glyphicon glyphicon-log-in" ></span> HomePage </button>
    </form>
  </div> -->
  <!-- <script>
  function DateValidate() {
	    // The function returns the product of p1 and p2
	  var expiryDate = document.getElementById("expiryDate").value;
	  var today = new Date(); // gets the current date
	  var today_mm = today.getMonth() + 1; // extracts the month portion
	  var today_yy = today.getFullYear() % 100; // extracts the year portion and changes it from yyyy to yy format
	  if(today_mm < 10) { // if today's month is less than 10
	      today_mm = '0' + today_mm // prefix it with a '0' to make it 2 digits
	  } 
	  var mm = expiryDate.substring(0, 2); // get the mm portion of the expiryDate (first two characters)
	  var yy = expiryDate.substring(3); // get the yy portion of the expiryDate (from index 3 to end)
	  if (yy > today_yy || (yy == today_yy && mm >= today_mm)) {
	     // all good because the yy from expiryDate is greater than the current yy
	     // or if the yy from expiryDate is the same as the current yy but the mm
	     // from expiryDate is greater than the current mm
	     return true;
	  }
	  else
	  {
	     alert("The expiry date needs to be greater than today.\n");
	     return false;
	  }
	}
  </script> -->
    <script> $('form').validate({
        errorClass: 'errors',
    	rules: {
    		phoneNumber: {
    			required: true
               
                },
                source: {
                    required:true,
                    lettersonly:true
                    
                },
                destination: {
                    required:true,
                    lettersonly:true
                    
                },
                
                dateOfJourney: {
                    required:true
                    
                },
                distance: {
                    required:true
                    
                },
                
                foodPreference:{
                    required:true,
                    maxlength:1
                    
                },
                travellingWith:{
                	required:true,
                	maxlength:1
                }
            },
             
            highlight: function (element) {
                $(element).parent().addClass('error')
            },
            unhighlight: function (element) {
                $(element).parent().removeClass('error')
            }
        });
    </script>
  
</body>
</html>