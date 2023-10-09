
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
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Frontline Bank</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="viewbalanceservlet">Account</a></li>
            <li><a href="CardServlet">Card</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:50px">
    <h2>Add Account</h2>

    <form action="AddAccountServlet" method="post">
        <div class="form-group">
            <label for="AccountName">Account Name:</label>

            <input class="form-control" type="text" id="AccountName" name="AccountName"><br><br>

        </div>

        <div class="form-group">
            <label for="AccountType">Account Type:</label>

            <input class="form-control" type="text" id="AccountType" name="AccountType"><br><br>

        </div>


        <div class="form-group">
            <label for="AvailableFunds">Available Funds:</label>

            <input class="form-control" type="text" id="AvailableFunds" name="AvailableFunds"><br><br>
        </div>


        <div class="form-group">
            <label for="CurrentFunds">Current Funds:</label>

            <input class="form-control" type="text" id="CurrentFunds" name="CurrentFunds"><br><br>
        </div>

        <button class="btn btn-default" type="submit">submit</button>


    </form>
</div>
</body>
</html>
