
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bank</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>

    <% 
      
      String cardErr = (String)session.getAttribute("cardErr");
      String nameErr = (String)session.getAttribute("nameErr");
      String expErr = (String)session.getAttribute("expErr");
      String cvvErr = (String)session.getAttribute("cvvErr");
    %>
   
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Frontline Bank</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="#">Account</a></li>
            <li><a href="card/selectAll">Card</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Login</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          </ul>
        </div>
      </nav>

    <div class="container" style="margin-top:50px"> 
    <h2>Card Management</h2>

    <form action="card/add" method="post">
    <div class="form-group">
        <label for="cardNumber">Card Number: <br><span class = "text-danger"> <%=(cardErr != null ? cardErr : "")%> </span> </label>
        
            <input class="form-control" type="text" id="cardNumber" name="cardNumber"><br><br>
        
    </div>

    <div class="form-group">
    <label for="cardHolder">Card Holder:<br><span class = "text-danger"> <%=(nameErr != null ? nameErr : "")%> </span></label>
   
    <input class="form-control" type="text" id="cardHolder" name="cardHolder"><br><br>
    
    </div>


    <div class="form-group">
    <label for="cardType">Card Type:</label>
    
    <input class="form-control" type="text" id="cardType" name="cardType"><br><br>
    </div>


    <div class="form-group">
    <label for="cardExpiry">Card Expiry: <br><span class = "text-danger"> <%=(expErr != null ? expErr : "")%> </span></label>

    <input class="form-control" type="text" id="expiryDate" name="expiryDate"><br><br>
    </div>



    <div class="form-group">
    <label for="cardCvv">Card CVV: <br><span class = "text-danger"> <%=(cvvErr != null ? cvvErr : "")%> </span></label>

    <input class="form-control" type="text" id="cvv" name="cvv"><br><br>
    </div>

    <button class="btn btn-default" type="submit">submit</button>
    

    </form>
    </div>
</body>
</html>
