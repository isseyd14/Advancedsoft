
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

        .profile {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: auto;
            padding: 10px;
            border-radius: 10px;
            height: 80vh;
            border: 1px solid black;
            width: 45%;
        }

        .deposit_inp {
            width: 30%;
        }

        h2 {
            margin-bottom: 5%;
        }

        #submit {
            margin-top: 5%;
            height: 20%;
            width: 20%;
        }

        #Accounts {
            height: 25px;
            width: 70%;
        }

        form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 70%;
        }

        .Account_box {
            margin-top: 2%;
            width: 50%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .row {
            margin-top: 3%;
            margin: auto;
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
            <li><a href="admin-ViewAccount.jsp">Back</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="body">
    <div class="profile">
        <h2>User Details</h2>
        <form action="${pageContext.request.contextPath}/AdminUpdateUserServlet" method="get">
            <div class="row">
                <div class="col-md-6">
                    <label>Email: </label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="email" value="${user.email}" readonly/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>First Name:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="fName" value="${user.fname}" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Last Name:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="lName" value="${user.lname}" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Address:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="address" value="${user.address}" />
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label id="date">Date of Birth:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="dob" value="${user.dob}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Phone Number:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="phone" value="${user.phone}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>New Password:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="newPassword"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Confirm Password:</label>
                </div>
                <div class="col-md-6">
                    <input type="text" name="Password"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <button class="btn btn-info" type="submit">Save Changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
