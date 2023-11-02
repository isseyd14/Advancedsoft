<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: tmcm0
  Date: 18/10/2023
  Time: 5:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Withdraw Page</title>
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
            height: 60vh;
            border: 1px solid black;
            width: 45%;
        }

        .deposit_inp {
            width: 30%;
        }

        h2 {
            margin-bottom: 2%;
        }

        .submit {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 5%;
            width: 50%;
            height: 10%;
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
        }

        .Account_box {
            margin-top: 2%;
            width: 50%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
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
        <h2>Withdraw</h2>
        <form action="WithdrawServlet" method="Get">
            <label>Amount:</label>
            <input class="deposit_inp" type="text" name="withdraw" placeholder="$">
            <div class="Account_box">
                <label for="Accounts">Choose an Account:</label>
                <select id="Accounts" name="accounts">
                    <c:forEach items="${accounts}" var="account">
                        <option value="${account.accountNumber}">${account.accountName}, ${account.accountNumber}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="submit">
            <button class="btn btn-info" type="submit" name="action" value="submit">Withdraw</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
