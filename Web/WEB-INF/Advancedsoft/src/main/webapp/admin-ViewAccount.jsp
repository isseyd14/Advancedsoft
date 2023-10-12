<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value="${sessionScope.user}" />
<c:set var="accounts" value="${sessionScope.accounts}" />
<%--
  Created by IntelliJ IDEA.
  User: tmcm0
  Date: 8/10/2023
  Time: 11:34 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Page</title>
    <style>
        .Header {
            background-color: #222; /* Slightly darker grey for the header */
            padding: 1px 0;
            text-align: left;
            display: flex; /* Enable flexbox layout for header */
            align-items: center; /* Vertically center content */
            justify-content: left; /* Vertically center content */
            height: 10vh;

        }

        .body {
            margin: auto;
            height: 80vh;
        }

        .profile {
            margin-left: 20%;
            margin-right: 20%;
            margin-top: 1%;
            padding: 10px;
            border-radius: 10px;
            height: 75vh;
        }

        .account_info {
            float: left;
            margin: auto;
            margin-left: 1%;
            width: 17%;
            height: 40%;
            border: 1px solid black;
            border-radius: 10px;
        }

        .accounts_view {
            margin: auto;
            margin-top: 5px;
            border: 1px solid black;
            border-radius: 10px;
            display: flex; /* Use flexbox */
            flex-direction: column; /* Stack child elements vertically */
            height: auto; /* Allow the container to grow based on its content */
            max-height: 80vh; /* Set a maximum height if needed */
            overflow-y: auto;
        }

        #search_tf {
            margin-left: 32%;
            width: 15%;
            height: 30px;
            border: 1px solid black;
        }
        #create_btn {
            margin-left: 2%;
            width: 8%;
            height: 40px;
            border: 1px solid black;
        }

        #logout_btn {
            float: right;
            margin-right: 2%;
            width: 8%;
            height: 40px;
            border: 1px solid black;
            border-radius: 5px;
        }

        .account_actions {
            display: flex;
            margin: auto;
            margin-top: 5%;
            width: 40%;
            height: 8%;
            justify-content: center;
            align-items: center;
        }

        .account_details {
            display: block;
            float: left;
            margin-top: 5%;
            margin-left: 3%;
        }

        .form_row {
            margin-top: 10%;
            margin-left: 3%;
            margin-bottom: 10px;
        }

        #actions_bar {
            padding: 10px;
        }

        label {
            font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
            "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
        }

        #add_btn {
            margin-right: 30px;
            width: 20vh;
            height: 5vh;
            background-color: transparent;
        }

        #del_btn {
            width: 20vh;
            height: 5vh;
            background-color: transparent;
        }

        .account_box {
            display: flex;
            width: 80%;
            height: 80px;
            border: 1px solid black;
            border-radius: 10px;
            margin-left: 10%;
            margin-top: 2%;
            margin-bottom: 2%;
        }

        .account_name {
            padding: 1%;
            font-size: 20px;
            height: 40%;
            margin-left: 5%;
        }

        .accountNum_wrapper {
            display: flex;
            margin-top: 1%;
        }

        .account_number {
            padding: 2px;
            font-size: 12px;
            word-spacing: 20px;
            margin-left: 5%;
        }

        #header_form {
            margin: auto;
            width: 100%;
        }

        .account_wrapper {
            display: flex;
            margin: auto;
            height: 70%;
            width: 90%;
            justify-content: space-between;
        }

        .accountName_wrapper {
            display: flex;
            margin-top: 1%;
            flex-direction: column;
            width: 49%;
            height: 100%;
        }
        .balance_wrapper {
            display: flex;
            flex-direction: column;
            float: right;
            width: 49%;
            height: 100%;
            justify-content: center;
            align-items: center;
        }

        .available_title {
            margin-top: 2%;
            margin-left: 2%;
            padding: 1%;
            font-size: 14px;
            color: gray;
        }

        .balance {
            padding: 1%;
            font-size: 16px;
        }

        .curbalance_wrapper {
            display: flex;
            flex-direction: column;
            float: right;
            width: 49%;
            height: 100%;
            justify-content: center;
            align-items: center;
        }

        .account_menu {
            position: relative;
            display: flex;
            flex-direction: column;
            width: 5%;
            height: 100%;
            justify-content: center;
            align-items: center;
        }

        .account_menu img {
            width: 25px;
            height: 25px;
        }

        .account_menu .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 100px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        /* Style for the dropdown links */
        .account_menu .dropdown-content button {
            background-color: transparent;
            border: none;
            color: black; /* Change this to the color you want */
            text-align: left;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            width: 100%;
            cursor: pointer;
        }

        /* Change color on hover */
        .account_menu .dropdown-content button:hover {
            background-color: #b4b4b4;
        }

        /* Display the dropdown on hover */
        .account_menu:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>
<div class="Header">
    <form id="header_form">
<%--        <button type="button" id="create_btn">Create Account</button>--%>
        <input type="text" id="search_tf" placeholder="Search" />
        <button type="button" id="logout_btn">Logout</button>
    </form>
</div>
<div class="body">
    <div class="account_info">
        <form>
            <div class="form_row">
                <label id="accountId_T">Email:</label>
                <label id="account_id">${user.email}</label>
            </div>
            <div class="form_row">
                <label id="name_T">First Name:</label>
                <label id="name">${user.firstName}</label>
            </div>
            <div class="form_row">
                <label id="dob_T">Last Name:</label>
                <label id="dob">${user.lastName}</label>
            </div>
            <div class="form_row">
                <label id="email_T">Date of Birth:</label>
                <label id="email">${user.DOB}</label>
            </div>
        </form>
    </div>
    <div class="profile">
        <div class="accounts_view">
            <c:forEach items="${accounts}" var="account">
            <div class="account_box">
                <form class="account_wrapper">
                    <div class="accountName_wrapper">
                        <label class="account_name">${account.accountName}</label>
                        <div class="accountNum_wrapper">
                            <label class="account_number">${account.accountNumber}</label>
                            <label class="account_number">028-611</label>
                        </div>
                    </div>
                    <div class="balance_wrapper">
                        <label class="available_title">Available</label>
                        <label class="balance">$${account.accountAvailableFunds}</label>
                    </div>
                    <div class="curbalance_wrapper">
                        <label class="available_title">Current</label>
                        <label class="balance">$${account.accountCurrentFunds}</label>
                    </div>
                        <div class="account_menu">
<%--                            <img src="Images\options.png" />--%>
                            <form action="AdminAccountDeleteServlet" method="post">
                                <input type="hidden" name="accountNumber" value="${account.accountNumber}">
                                <button type="submit" id="del_btn">Delete</button>
                            </form>
                        </div>
                </form>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>



<%--<div class="dropdown-content">--%>
<%--    <form method="post" action="${pageContext.request.contextPath}/AdminAccountDeleteServlet">--%>
<%--        <input type="hidden" name="accountNumber" value="${account.accountNumber}">--%>
<%--        <button type="submit" name="action" value="edit">Edit</button>--%>
<%--        <button type="submit" name="action" value="delete">Delete</button>--%>
<%--    </form>--%>
<%--</div>--%>