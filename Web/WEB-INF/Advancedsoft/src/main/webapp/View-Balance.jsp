<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts</title>
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
<!-- create the list of accounts that are attached to the user -->
<div  class="container" style="margin-top:50px">
    <table class="table table-hover">
        <caption><h2>List of Accounts</h2></caption>
        <tr>
            <th>Account Number</th>
            <th>Account Name</th>
            <th>Account Type</th>
            <th>Available Funds</th>
            <th>Current Funds</th>

        </tr>
        <c:forEach var="account" items="${listaccount}">
            <tr>
                <td><c:out value="${account.accountNumber}" /></td>
                <td><c:out value="${account.accountName}" /></td>
                <td><c:out value="${account.accountType}" /></td>
                <td><c:out value="${account.accountAvailableFunds}" /></td>
                <td><c:out value="${account.accountCurrentFunds}" /></td>
                <td>
                    <a href="viewHistoryServlet?contactId=${account.accountNumber}">view History</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- error message if there are no accounts -->
    <c:if test="${empty listaccount}">
        <p>No accounts found for this user.</p>
    </c:if>
</div>
<!-- button for adding new accounts -->
<div>
    <a href="add-account.jsp" class="btn btn-info" role="button">Add New Account</a>
</div>

</body>
</html>
