<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>Bank</title>
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
<!-- creates from with two drop down menus, one for accounts and one for contacts -->
<div class="container" style="margin-top:50px">
  <h2>Add Account</h2>
  <form action="moveMoneyServlet" method="post">
    <div class="form-group">
      <label for="ContactName">Select Contact:</label>
      <select class="form-control" name="ContactName">
        <option value="">Select a contact</option> <!-- Optional default option -->
        <c:forEach var="contact" items="${listcontacts}">
          <option value="${contact.contactId}">
            <c:out value="${contact.contactName}" />
          </option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label for="AccountName">Select Account:</label>
      <select class="form-control" name="AccountName">
        <option value="">Select an account</option> <!-- Optional default option -->
        <c:forEach var="account" items="${listaccount}">
          <option value="${account.accountNumber}">
            <c:out value="${account.accountName}" />
          </option>
        </c:forEach>
      </select>
    </div>


    <div class="form-group">
      <label for="Amount">Select Account:</label>

      <input class="form-control" type="text" id="Amount" name="Amount"><br><br>
    </div>


    <button class="btn btn-default" type="submit">submit</button>

  </form>
</div>
</body>
</html>
