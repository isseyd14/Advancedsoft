<%--
  Created by IntelliJ IDEA.
  User: issey
  Date: 7/09/2023
  Time: 8:34 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <style>
        /* Style for aligning form elements */
        label {
            display: inline-block;
            width: 150px; /* Adjust the width as needed for your layout */
            text-align: right;
            margin-right: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 200px; /* Adjust the width as needed for your layout */
        }

        button[type="submit"] {
            margin-left: 160px; /* Adjust the margin as needed for your layout */
        }
    </style>
</head>
<body>
<h2>Registration Page</h2>
<form action="Registerservlet" method="post">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required><br><br>

    <label for="confirm_password">Confirm Password:</label>
    <input type="password" name="confirm_password" id="confirm_password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
