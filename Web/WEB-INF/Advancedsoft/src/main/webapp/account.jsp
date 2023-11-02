<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="uts.bank.model.User" %>
<%@ page import="uts.bank.Controller.*" %>
>

<!DOCTYPE html>
<html lang="en">
<head>
 <!-- security logic to check if there is a user logged in if not it sends back to index -->
    <%
        boolean isLoggedIn = (session.getAttribute("email") != null);
        if(!isLoggedIn){
            response.sendRedirect("index.jsp");
            return;
        }
    %>
  <style>
    .logo {
      max-width: 40px; /* Adjust the maximum width as needed */
      margin-right: 20px; /* Add some spacing between the logo and text */
      max-height: 40px;
    }
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Accounts</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <img src="logo.png" alt="Logo" class="logo">

      <a class="navbar-brand" href="#">Frontline Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="View-Balance.jsp">Home</a></li>
      <li><a href="Pay-Transfer.jsp">Pay and Transfer</a></li>
      <li><a href="account.jsp">Account</a></li>
      <li><a href="savecontactservlet">Contacts Management</a></li>
      <li><a href="card/selectByCustomerId">Card</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<div  class="container" style="margin-top:50px">
  <table class="table table-hover">
    <caption><h2>Account details</h2></caption>
    <tr>
      <th>First name</th>
      <th>Last name</th>
      <th>Phone</th>
      <th>Address</th>

    </tr>
    <%        User iop = (User) session.getAttribute("User");%>
      <tr>
        <td><%=iop.getFname()%></td>
        <td><%=iop.getLname()%></td>
        <td><%=iop.getPhone()%></td>
        <td><%=iop.getAddress()%></td>

        <td>
        </td>
      </tr>

  </table>
  <c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
  </c:if>
  <form action="EditAcc.jsp" method="post" >
    <button type="submit" class="btn btn-primary" name="changePassword">Edit Details</button>
  </form>
  <br>
  <form action="ChangePassword.jsp" method="post">
    <button type="submit" class="btn btn-primary" name="changePassword">Change Password</button>
  </form>
  <br>
  <form action="DeleteAccServlet" method="post" onsubmit="return confirm('Are you sure you want to delete your account? This action cannot be undone.');">
    <button type="submit" class="btn btn-danger" name="deleteAccount">Delete Account</button>
  </form>
</div>


</div>
</div>
</div>
</body>
</html>
