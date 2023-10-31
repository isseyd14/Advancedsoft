
<%--
  Created by IntelliJ IDEA.
  User: tmcm0
  Date: 18/10/2023
  Time: 06:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>UserDetails Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        .body {
            display: flex;
            flex-direction: column;
            margin: auto;
            height: 100vh;
        }

        .box {
            display: flex;
            flex-direction: column;
            align-items: center; /* Adjust width as needed */
            height: 30%;
            margin-top: 5%;
            border: 1px solid black;
        }

        .box button {
            /* Style for each button in the nav */
            padding: 10px 20px;
            background-color: #f0f0f0; /* Adjust background color as needed */
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .box button:hover {
            background-color: #e0e0e0; /* Adjust hover background color as needed */
        }

        .box_bar {
            margin: auto;
        }

        .profile {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-left: 20%;
            margin-right: 20%;
            margin-top: 1%;
            padding: 10px;
            border-radius: 10px;
            height: 75vh;
            border: 1px solid black;
        }

        .account_info {
            display: flex;
            flex-direction: column; /* Display elements in a single column */
            align-items: center;
            margin: auto;
            padding: 1%;
            width: 90%;
            border-radius: 10px;
        }

        .form_row {
            margin: auto;
            padding-top: 5px;
            text-align: center;
        }

        label {
            font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
            "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
        }

        .action_box {
            margin: auto;
            height: 90%;
            width: 70%;
            border: 1px solid black;
            border-radius: 5px;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Frontline Bank</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="admin.jsp">Home</a></li>
            <li><a href="#">Create Account</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="body">
    <div class="box">
        <div class="account_info">
            <div class="form_row">
                <label id="email_T">Email:</label>
                <label id="email_id">${user.email}</label>
            </div>
            <div class="form_row">
                <label id="name_T">First Name:</label>
                <label id="name">${user.fname}</label>
            </div>
            <div class="form_row">
                <label id="lname_T">Last Name:</label>
                <label id="lname">${user.lname}</label>
            </div>
            <div class="form_row">
                <label id="dob_T">Date of Birth:</label>
                <label id="dob">${user.dob}</label>
            </div>
        </div>
        <div class="box_bar">
            <button>Accounts</button>
            <button><a href="deposit.jsp">Deposit</a></button>
            <button>Withdraw</button>
            <button>Transactions</button>
        </div>
    </div>
    <div class="profile">
        <form class="action_box">
            <h2>Deposit</h2>
        </form>
    </div>
</div>
</body>
</html>
