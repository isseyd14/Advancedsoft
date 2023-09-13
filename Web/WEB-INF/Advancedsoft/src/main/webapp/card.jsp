<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <center>
        <h1>Card Management</h1>
        <h2>
            
           
            &nbsp;&nbsp;&nbsp;
            
           
             
        </h2>
    </center>
    <div class="container">
        <table class="table table-hover">
            <caption><h2>List of Cards</h2></caption>
            <tr>
                <th>Card Number</th>
                <th>Card Holder</th>
                <th>Action</th>

            </tr>
            <c:forEach var="card" items="${listCard}">
                <tr>
                    <td><c:out value="${card.cardNumber}" /></td>
                    <td><c:out value="${card.cardHolder}" /></td>
                    <td>
                        <!-- <a href="/edit?id=<c:out value='${book.id}' />">active</a> -->
                        <!-- &nbsp;&nbsp;&nbsp;&nbsp; -->
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
      
    <div>
    <a href="new" class="btn btn-info" role="button">Add New Card</a>
    </div>
    </div> 
</body>
</html>