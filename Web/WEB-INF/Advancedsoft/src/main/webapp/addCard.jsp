
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Books Store Application</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Frontline Bank</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="#">Account</a></li>
            <li><a href="CardServlet">Card</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Login</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          </ul>
        </div>
      </nav>

    <div class="container" style="margin-top:50px"> 
    <h2>Card Management</h2>

    <form action="AddCardServlet" method="post">
    <div class="form-group">
        <label for="cardNumber">Card Number:</label>
        
            <input class="form-control" type="text" id="cardNumber" name="cardNumber"><br><br>
        
    </div>

    <div class="form-group">
    <label for="cardHolder">Card Holder:</label>
   
    <input class="form-control" type="text" id="cardHolder" name="cardHolder"><br><br>
    
    </div>


    <div class="form-group">
    <label for="cardType">Card Type:</label>
    
    <input class="form-control" type="text" id="cardType" name="cardType"><br><br>
    </div>


    <div class="form-group">
    <label for="cardExpiry">Card Expiry:</label>

    <input class="form-control" type="text" id="expiryDate" name="expiryDate"><br><br>
    </div>



    <div class="form-group">
    <label for="cardCvv">Card CVV:</label>

    <input class="form-control" type="text" id="cvv" name="cvv"><br><br>
    </div>

    <button class="btn btn-default" type="submit">submit</button>
    

    </form>
    </div>
</body>
</html>
