<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pay-Transfer</title>
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
</head>
<body>
<header>
  <h1>Pay and Transfer</h1>
</header>

<div class="banner">
  <h2>Hi welcome to Frontline bank please login by clicking below</h2>
</div>
<div class="centered-button-container">
  <a href="login.jsp" class="centered-button">Go to Login</a>
</div>
</body>
</html>
