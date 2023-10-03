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
    <title>Frontline Bank - Create an Account</title>
    <style>
        /* Your existing styles here */

        /* Add additional styles for the new form fields if needed */
        .form-group input[type="text"],
        .form-group input[type="password"],
        .form-group input[type="number"],
        .form-group input[type="date"] {
            /* Your styles for form fields here */
            width: 20%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
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
            padding: 1px 0;
            text-align: left;
            display: flex; /* Enable flexbox layout for header */
            align-items: center; /* Vertically center content */
            justify-content: left; /* Vertically center content */

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
        .logo {
            max-width: 100px; /* Adjust the maximum width as needed */
            margin-right: 20px; /* Add some spacing between the logo and text */
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
    <img src="logo.png" alt="Logo" class="logo">
    <h1>Frontline Bank</h1>
</header>

<div class="banner">
    <h2>Hi, welcome to Frontline Bank. Please create your account.</h2>
</div>

<div class="container">
    <!-- Create Account Form -->
    <div class="login-container">
        <div class="login-box">
            <h3>Create an Account</h3>
            <form action="RegisterServlet" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>
                <div class="form-group">
                    <label for="Firstname">First Name:</label>
                    <input type="text" id="Firstname" name="Firstname" required>
                </div>
                <div class="form-group">
                    <label for="Lastname">Last Name:</label>
                    <input type="text" id="Lastname" name="Lastname" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="startingBalance">Starting Balance:</label>
                    <input type="number" id="startingBalance" name="startingBalance" required>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birtsh:</label>
                    <input type="date" id="dob" name="dob" required>
                </div>
                <div class="form-group">
                    <label for="phone">phone:</label>
                    <input type="text" id="phone" name="phone" required>
                </div>
                <div class="form-group">
                    <input type="submit" value="Create Account">
                </div>
            </form>
            <c:if test="${not empty errorMessage}">
                <p style="color: red;">${errorMessage}</p>
            </c:if>
            <div class="centered-button-container">
                <a href="login.jsp" class="centered-button">Already have an account? Log in</a>
            </div>
        </div>
    </div>
</div>

<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("Password and Confirm Password do not match.");
            return false;
        }

        if (startingBalance < 0) {
            alert("Starting Balance cannot be negative.");
            return false;
        }

        return true;
    }

</script>

</body>
</html>
