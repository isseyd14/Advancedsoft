<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="uts.bank.model.user" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Accounts</title>
  <%
    boolean isLoggedIn = (session.getAttribute("email") != null);
    if(!isLoggedIn){
      response.sendRedirect("login.jsp");
      return;
    }
  %>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Frontline Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="Pay-Transfer.jsp">Pay and Transfer</a></li>
      <li><a href="savecontactservlet">Contacts Management</a></li>
      <li><a href="CardServlet">Card</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<%        user iop = (user) session.getAttribute("User");%>

  <table class="table table-bordered">
  <thead>
  <tr>
    <th>First name</th>
    <th>Last name</th>
    <th>Phone</th>
    <th>Address</th>
  </tr>
  </thead>
  <tbody>
    <tr>
      <td><%=iop.getFname()%></td>
      <td><%=iop.getLname()%></td>
      <td><%=iop.getPhone()%></td>
      <td><%=iop.getAddress()%></td>
      <td><a href="editAccount.jsp?accountNumber=${account.accountNumber}">Edit</a></td>
    </tr>
  </tbody>
</table>

delete account button

</body>
</html>