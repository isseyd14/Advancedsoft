<%--
  Created by IntelliJ IDEA.
  User: tmcm0
  Date: 6/10/2023
  Time: 11:43 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="admin.css" />
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
            border: solid 2px black;
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
            display: flex;
            margin: auto;
            margin-top: 5px;
            height: 80%;
            border: 1px solid black;
            border-radius: 10px;
            justify-content: center;
            align-items: center;
        }

        #search_tf {
            margin-left: 32%;
            width: 15%;
            height: 30px;
            border: 1px solid black;
            border-radius: 5px;
        }
        #create_btn {
            margin-left: 2%;
            width: 8%;
            height: 40px;
            border: 1px solid black;
        }

        #logout_btn {
            float: left;
            margin-left: 30%;
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
            width: 30%;
            height: 30%;
            border: 1px solid black;
            border-radius: 10px;
            margin: auto;
        }

        .account_name {
            float: left;
            margin-top: 20%;
            margin-left: 10px;
        }

        .account_number {
            float: left;
            margin-top: 5%;
            margin-right: 30%;
            margin-left: 10px;
            font-size: 12px;
            word-spacing: 7px;
        }

        .balance {
            float: right;
            margin-top: -14%;
            margin-right: 15%;
        }
    </style>
</head>
<body>
<div class="Header">
    <button type="button" id="create_btn">Create Account</button>
    <input type="text" id="search_tf" placeholder="Search" />
    <button type="button" id="logout_btn">Logout</button>
</div>
<div class="body">
    <div class="account_info">
        <form action="/AdminServlet" method="post">
            <div class="form_row">
                <label id="accountId_T">Account Id: </label>
                <label id="account_id"></label>
            </div>
            <div class="form_row">
                <label id="name_T">Name:</label>
                <label id="name"></label>
            </div>
            <div class="form_row">
                <label id="dob_T">Date of Birth:</label>
                <label id="dob"></label>
            </div>
            <div class="form_row">
                <label id="email_T">Email:</label>
                <label id="email"></label>
            </div>
        </form>
    </div>
    <div class="profile">
        <div class="accounts_view">
            <div class="account_box">
                <form action="/AdminServlet" method="get">
                    <label class="account_name">Account Name</label>
                    <label class="account_number">1200-4386 028-611</label>
                    <label class="balance">$1200</label>
                </form>
            </div>
            <div class="account_box"></div>
        </div>
        <div class="account_actions">
            <form id="actions_bar">
                <button type="button" id="add_btn">Add</button>
                <button type="button" id="del_btn">Delete</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
