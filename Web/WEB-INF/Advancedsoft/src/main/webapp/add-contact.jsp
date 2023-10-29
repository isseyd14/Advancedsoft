
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
  <!-- security logic to check if there is a user logged in if not it sends back to index -->
  <%
    boolean isLoggedIn = (session.getAttribute("email") != null);
    if(!isLoggedIn){
      response.sendRedirect("index.jsp");
      return;
    }
  %>
</head>
<body>
<!-- navigation bar for website -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Frontline Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active">
        <img src="logo.png" alt="Logo" width="40" height="40" class="d-inline-block align-text-top">
      </li>
      <li><a href="viewbalanceservlet">View Accounts</a></li>
      <li><a href="paytransferservlet">Pay and Transfer</a></li>
      <li><a href="account.jsp">Account</a></li>
      <li><a href="savecontactservlet">Contacts Management</a></li>
      <li><a href="card/selectByCustomerId">Card</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<!-- creates form for the user to create a contact -->
<div class="container" style="margin-top:50px">
  <h2>Add Contact</h2>


  <!-- Display error messages if they are present -->
  <%
    String error = request.getParameter("error");
    if ("invalid-email".equals(error)) {
  %>
  <div class="alert alert-danger">
    Invalid email format. Please enter a valid email address.
  </div>
  <%
  } else if ("invalid-account-number".equals(error)) {
  %>
  <div class="alert alert-danger">
    Invalid account number. Please enter a valid numeric account number.
  </div>
  <%
    }
  %>

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
    <div class="form-group">
      <label for="accountNumber">account Number:</label>

      <input class="form-control" type="text" id="accountNumber" name="accountNumber"><br><br>
    </div>

    <button class="btn btn-default" type="submit">submit</button>

  </form>
</div>
</body>
</html>
