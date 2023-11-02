<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var="user" value="${sessionScope.user}" />
<c:set var="accounts" value="${sessionScope.accounts}" />--%>
<%--
  Created by IntelliJ IDEA.
  User: tmcm0
  Date: 8/10/2023
  Time: 11:34 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Admin Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
    .Header {
      /*background-color: #222; !* Slightly darker grey for the header *!*/
      /*padding: 1px 0;*/
      text-align: left;
      display: flex; /* Enable flexbox layout for header */
      align-items: center; /* Vertically center content */
      justify-content: left; /* Vertically center content */
      height: 10vh;
    }

    .body {
      display: flex;
      flex-direction: column;
      margin: auto;
      height: 100vh;
    }

    .box {
      display: flex;
      flex-direction: column;
      align-items: center; /* Adjust width as needed */
      height: 30%;
      margin-top: 5%;
      border: 1px solid black;
    }

    .box button {
      /* Style for each button in the nav */
      padding: 10px 20px;
      background-color: #f0f0f0; /* Adjust background color as needed */
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    .box button:hover {
      background-color: #e0e0e0; /* Adjust hover background color as needed */
    }

    .box_bar {
      margin: auto;
    }

    .profile {
      margin-left: 20%;
      margin-right: 20%;
      margin-top: 1%;
      padding: 10px;
      border-radius: 10px;
      height: 75vh;
    }

    .account_info {
      display: flex;
      flex-direction: column; /* Display elements in a single column */
      align-items: center;
      margin: auto;
      padding: 1%;
      width: 90%;
      border-radius: 10px;
    }

    .accounts_view {
      margin: auto;
      border: 1px solid black;
      border-radius: 5px;
      display: flex; /* Use flexbox */
      flex-direction: column; /* Stack child elements vertically */
      height: auto; /* Allow the container to grow based on its content */
      max-height: 55vh; /* Set a maximum height if needed */
      overflow-y: auto;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.1);
    }

    .form_row {
      margin: auto;
      padding-top: 5px;
      text-align: center;
    }

    label {
      font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
      "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
    }

    .account_menu img {
      width: 25px;
      height: 25px;
    }

    .account_menu .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f9f9f9;
      min-width: 100px;
      box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
      z-index: 1;
    }

    /* Style for the dropdown links */
    .account_menu .dropdown-content button {
      background-color: transparent;
      border: none;
      color: black; /* Change this to the color you want */
      text-align: left;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
      width: 100%;
      cursor: pointer;
    }

    /* Change color on hover */
    .account_menu .dropdown-content button:hover {
      background-color: #b4b4b4;
    }

    /* Display the dropdown on hover */
    .account_menu:hover .dropdown-content {
      display: block;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Frontline Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="admin.jsp">Home</a></li>
      <li><a href="admin-ViewAccount.jsp">Back</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="body">
  <div class="box">
    <div class="account_info">
      <div class="form_row">
        <label id="email_T">Email:</label>
        <label id="email_id">${user.email}</label>
      </div>
      <div class="form_row">
        <label id="name_T">First Name:</label>
        <label id="name">${user.fname}</label>
      </div>
      <div class="form_row">
        <label id="lname_T">Last Name:</label>
        <label id="lname">${user.lname}</label>
      </div>
      <div class="form_row">
        <label id="dob_T">Date of Birth:</label>
        <label id="dob">${user.dob}</label>
      </div>
    </div>
  </div>
  <div class="profile">
    <form class="accounts_view" method="get" action="AdminUserTransactionServlet">
      <div style="max-height: 55vh; overflow-y: auto;">
        <table class="table table-hover">
          <tr>
            <th>Transaction ID</th>
            <th>From</th>
            <th>Amount</th>
            <th>To</th>
          </tr>
          <c:forEach items="${transactions}" var="transaction">
          <tr>
            <td>${transaction.transaction_id}</td>
            <td>${transaction.account_id}</td>
            <td>${transaction.amount}</td>
            <td>${transaction.payee_accountid}</td>
          </tr>
          </c:forEach>
          <c:if test="${empty transactions}">
            <tr>
              <td colspan="4"> No transactions found.</td>
            </tr>
          </c:if>
        </table>
      </div>
    </form>
  </div>
</div>
</body>
</html>
