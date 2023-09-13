
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
    <div class="container">
    <h2>Card Management</h2>

    <form action="add" method="post">
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
