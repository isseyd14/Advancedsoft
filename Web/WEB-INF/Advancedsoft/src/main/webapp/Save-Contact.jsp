<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacts</title>
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
            <li><a href="viewbalanceservlet">Accounts</a></li>
            <li><a href="CardServlet">Card</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div  class="container" style="margin-top:50px">
    <table class="table table-hover">
        <caption><h2>List of Contacts</h2></caption>
        <tr>
            <th>Name</th>
            <th>Contact Email</th>
            <th>Contact Nic Name</th>

        </tr>
        <c:forEach var="contact" items="${listcontacts}">
            <tr>
                <td><c:out value="${contact.contactName}" /></td>
                <td><c:out value="${contact.contactNicName}" /></td>
                <td><c:out value="${contact.contactEmail}" /></td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty listcontacts}">
        <p>No Contacts found for this user.</p>
    </c:if>
</div>

</body>
</html>
