<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Contact</title>
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
            <li><a href="viewbalanceservlet">View Accounts</a></li>
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
<!-- creates form autopopulated with contact information for the user to edit -->
<div class="container" style="margin-top: 50px;">
    <h2>Edit Contact</h2>
    <form action="updateContactServlet" method="post">
        <div class="form-group">
            <label for="contactName">Name</label>
            <input type="text" class="form-control" id="contactName" name="contactName" value="<c:out value='${contact.contactName}' />">
        </div>
        <div class="form-group">
            <label for="contactEmail">Contact Email</label>
            <input type="email" class="form-control" id="contactEmail" name="contactEmail" value="<c:out value='${contact.contactEmail}' />">
        </div>
        <div class="form-group">
            <label for="contactNicName">Contact Nic Name</label>
            <input type="text" class="form-control" id="contactNicName" name="contactNicName" value="<c:out value='${contact.contactNicName}' />">
        </div>
        <div class="form-group">
            <label for="accountNumber">Contact Account Number</label>
            <input type="number" class="form-control" id="accountNumber" name="accountNumber" value="<c:out value='${contact.accountNumber}' />">
        </div>
        <input type="hidden" name="contactId" id="contactId" value="<c:out value='${contact.contactId}' />">
        <button type="submit" class="btn btn-primary">Update Contact</button>
    </form>
</div>

</body>
</html>
