<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
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
        h1 {
            margin: 55px 0 0 0;
            font-size: 36px;
            margin-left: 10px;
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
    <h2>Hi welcome to Frontline bank please login by clicking below</h2>
</div>
<div class="centered-button-container">
    <a href="login.jsp" class="centered-button">Go to Login</a>
   
</div>
  
</body>
</html>
