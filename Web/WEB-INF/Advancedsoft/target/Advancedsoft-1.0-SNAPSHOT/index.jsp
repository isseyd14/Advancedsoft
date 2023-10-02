<!DOCTYPE html>
<html lang="en">
<head>
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
            max-width: 100px; /* Adjust the maximum width as needed */
            margin-right: 20px; /* Add some spacing between the logo and text */
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
</head>
<body>
<header>
    <img src="logo.png" alt="Logo" class="logo">
    <h1>Welcome to Frontline bank</h1>
</header>

<div class="banner">
    <h2>Hi welcome to Frontline bank please login by clicking below</h2>
</div>
<div class="centered-button-container">
    <a href="login.jsp" class="centered-button">Go to Login</a>
    <a href="card/selectAll" class="centered-button">Go to Card Management</a>
</div>
  
</body>
</html>
