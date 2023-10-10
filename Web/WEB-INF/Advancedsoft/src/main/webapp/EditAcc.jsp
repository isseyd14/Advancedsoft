<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="uts.bank.model.user" %>

<!DOCTYPE html>
<html lang="en">
<head>
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
    <title>Edit Details</title>
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
<%        user iop = (user) session.getAttribute("User");%>

<div class="container" style="margin-top: 50px;">
            <div class="panel-body">
                <caption><h2>Edit details</h2></caption>
                <br>
                <form action="UpdateUserServlet" method="post">
                    <div class="form-group">
                        <label for="fname">First Name:</label>
                        <input type="text" id="fname" name="fname" class="form-control" value="<%=iop.getFname()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="lname">Last Name:</label>
                        <input type="text" id="lname" name="lname" class="form-control" value="<%=iop.getLname()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" name="phone" class="form-control" value="<%=iop.getPhone()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" class="form-control" value="<%=iop.getAddress()%>" required>
                    </div>
                    <div class="form-group text-center">
                        <a href="account.jsp" class="btn btn-default">Cancel</a>
                        <input type="submit" class="btn btn-primary" value="Save Changes">
                    </div>
                </form>
                <c:if test="${not empty errorMessage}">
                    <p style="color: red;">${errorMessage}</p>
                </c:if>
            </div>
    </div>
</body>
</html>
