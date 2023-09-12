<%--
  Created by IntelliJ IDEA.
  User: issey
  Date: 7/09/2023
  Time: 4:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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

        /*.login-box {
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }*/
        h1 {
            font-size: 36px;
            color: white; /* White text color for the header */
        }
        .form-group {
            margin-bottom: 20px;
        }
        header {
            background-color: #222; /* Slightly darker grey for the header */
            padding: 20px 0;
            text-align: center;
        }

        .form-group label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="password"] {
            /*width: 100%;*/
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
<header>
    <h1>Welcome to Frontline Bank</h1>
</header>

<div class="banner">
    <h2>Hi, welcome to Frontline Bank. Please log in to your account.</h2>
</div>

<div class="container">
    <!-- Login Form -->
    <div class="login-container">
        <div class="login-box">
            <h3>Login</h3>
            <form action="RegisterServlet" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="Password">Password:</label>
                    <input type="Password" id="Password" name="Password" required>
                </div>
                <div class="form-group">
                    <input type="submit" value="Log In">
                </div>
            </form>
            <c:if test="${not empty errorMessage}">
                <p style="color: red;">${errorMessage}</p>
            </c:if>
            <div class="centered-button-container">
                <a href="Register.jsp" class="centered-button">Create an account</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>





