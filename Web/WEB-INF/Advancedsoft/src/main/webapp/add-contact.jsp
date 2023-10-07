
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
  <h2>Add Contact</h2>

  <form action="AddContactServlet" method="post">
    <div class="form-group">
      <label for="ContactName">Contact Name:</label>

      <input class="form-control" type="text" id="ContactName" name="ContactName"><br><br>

    </div>

    <div class="form-group">
      <label for="ContactNicName">Contact Nic Name:</label>

      <input class="form-control" type="text" id="ContactNicName" name="ContactNicName"><br><br>

    </div>

    <div class="form-group">
      <label for="ContactEmail">Contact Email:</label>

      <input class="form-control" type="text" id="ContactEmail" name="ContactEmail"><br><br>
    </div>

    <button class="btn btn-default" type="submit">submit</button>

  </form>
</div>
</body>
</html>
