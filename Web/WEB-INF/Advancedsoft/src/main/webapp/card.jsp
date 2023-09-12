<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="addCard.jsp">Add New Card</a>
            &nbsp;&nbsp;&nbsp;
           
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Cards</h2></caption>
            <tr>
                <th>Number</th>
                <th>Holder Name</th>

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
    </div>   
</body>
</html>