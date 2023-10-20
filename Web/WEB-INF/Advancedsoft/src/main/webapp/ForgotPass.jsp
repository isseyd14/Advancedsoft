<%--
  Created by IntelliJ IDEA.
  User: issey
  Date: 7/09/2023
  Time: 4:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frontline Bank - Login</title>
    <style>
        .banner {
            /*  background-image: url('your-banner-image.jpg'); /* Replace with your banner image URL */
            background-size: contain; /* Fit the image within the container */
            background-repeat: no-repeat; /* Prevent image repetition */
            background-position: right top; /* Position the image in the top-right corner */
            height: 50px; /* Adjust the height as needed */
            display: flex;
            justify-content: center;
            align-items: center;
        }
        body {
            margin: 0;
            padding: 0;
            background-color: white; /* White background */
            color: black; /* Black text */
            font-family: Arial, sans-serif;
            justify-content: center;
            align-items: center;
        }
        .login-container {
            text-align: center;
            margin-top: 50px;
        }

        h1 {
            margin: 55px 0 0 0;
            font-size: 36px;
            margin-left: 10px;
            color: white; /* White text color for the header */
        }
        .form-group {
            margin-bottom: 20px;
        }
        header {
            background-color: #222; /* Slightly darker grey for the header */
            padding: 12px 0;
            text-align: left;
            display: flex; /* Enable flexbox layout for header */
            align-items: center; /* Vertically center content */
            justify-content: left; /* Vertically center content */

        }

        .logo {
            max-width: 40px; /* Adjust the maximum width as needed */
            margin-right: 20px; /* Add some spacing between the logo and text */
            max-height: 40px;
        }

        .form-group label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: 20%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
        .form-group input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <img src="logo.png" alt="Logo" class="logo">
            <a class="navbar-brand" href="#">Frontline Bank</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
        </ul>
    </div>
</nav>

<div class="banner">
    <h2>Hi, welcome to Frontline Bank. Please log in to your account.</h2>
</div>

<div class="container">
    <!-- Login Form -->
    <div class="login-container">
        <div class="login-box">
            <h3>Login</h3>
            <form action="sendEmailServlet" method="post">
                <div class="form-group">
                    <label for="email">Forgotten Email:</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <input type="submit" value="Submit">
                </div>
            </form>
            <c:if test="${not empty errorMessage}">
                <p style="color: red;">${errorMessage}</p>
            </c:if>
            <div class="centered-button-container">
                <a href="login.jsp" class="centered-button">Cancel</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
