<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <table class="table table-hover">
            <caption><h2>List of Cards</h2></caption>
            <tr>
                <th class="col-md-3">Card Number</th>
                <th class="col-md-3">Pin</th>
                <th class="col-md-3">Status</th>
                <th class="col-md-3">Action</th>

            </tr>
            <c:forEach var="card" items="${listCard}">
                <tr>
                    <td><c:out value="${card.cardNumber}" /></td>
                    <td><c:out value="${card.pin}" /></td>
                    <td><c:out value="${card.cardStatus}" /></td>
                   
                    <td>
                      <a href="card/changePin?cardNumber=<c:out value='${card.cardNumber}' />" class="btn btn-info" role="button">Change Pin</a>
                      <a href="card/delete?cardNumber=<c:out value='${card.cardNumber}' />" class="btn btn-info" role="button">Delete</a> 
                      <c:if test="${card.cardStatus == 'Active'}">
                        <a href="card/deactivate?cardNumber=<c:out value='${card.cardNumber}' />" class="btn btn-info" role="button">Block</a>
                      </c:if>
                      <c:if test="${card.cardStatus == 'Inactive'}">  
                        <a href="card/activate?cardNumber=<c:out value='${card.cardNumber}' />" class="btn btn-info" role="button">Activate</a>
                      </c:if>
                                           
                    </td>
                </tr>
            </c:forEach>
        </table>
      
    <div>
    <a href="addCard.jsp" class="btn btn-info" role="button">Add New Card</a>
    </div>
    </div> 
</body>
</html>