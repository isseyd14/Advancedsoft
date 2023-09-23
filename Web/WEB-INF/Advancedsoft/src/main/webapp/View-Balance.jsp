<%@ page import="uts.bank.model.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: white; /* White background */
            color: black; /* Black text */
            font-family: Arial, sans-serif;
            justify-content: center;
            align-items: center;
        }

        header {
            background-color: #222; /* Slightly darker grey for the header */
            padding: 20px 0;
            text-align: center;
        }

        h1 {
            font-size: 36px;
            color: white; /* White text color for the header */
        }


        .banner {
            /*  background-image: url('your-banner-image.jpg'); /* Replace with your banner image URL */
            background-size: contain; /* Fit the image within the container */
            background-repeat: no-repeat; /* Prevent image repetition */
            background-position: right top; /* Position the image in the top-right corner */
            height: 300px; /* Adjust the height as needed */
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            max-width: 960px;
            margin: 0 auto;
            padding: 20px;
        }

        p {
            font-size: 18px;
        }
        .centered-button-container {
            text-align: center;
        }

        .centered-button {
            padding: 10px 20px;
            background-color: #007bff; /* Blue button color */
            color: white; /* White text color for the button */
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
    <%
        boolean isLoggedIn = (session.getAttribute("email") != null);
        if(!isLoggedIn){
            response.sendRedirect("login.jsp");
            return;
        }
    %>
</head>
<body>
<header>
    <h1>Accounts</h1>
</header>
<div >
    <table class="table table-hover">
        <caption><h2>List of Accounts</h2></caption>
        <tr>
            <th>Account Name</th>
            <th>Account Type</th>
            <th>Available Funds</th>
            <th>Current Funds</th>

        </tr>
        <c:forEach var="account" items="${listaccount}">
            <tr>
                <td><c:out value="${account.accountName}" /></td>
                <td><c:out value="${account.accountType}" /></td>
                <td><c:out value="${account.accountAvailableFunds}" /></td>
                <td><c:out value="${account.accountCurrentFunds}" /></td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty listaccount}">
        <p>No accounts found for this user.</p>
    </c:if>
</div>

</body>
</html>
