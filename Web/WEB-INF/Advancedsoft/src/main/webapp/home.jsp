<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frontline Bank</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: white;
            color: black;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #222;
            padding: 1px 0;
            display: flex;
            align-items: center;
            justify-content: left;
        }

        .logo {
            max-width: 100px;
            margin-right: 20px;
        }

        h1 {
            margin: 55px 0 0 10px;
            font-size: 36px;
            color: white;
        }

        nav {
            margin-right: auto; /* Pushes the navigation to the right */
        }

        .nav-menu {
            list-style: none;
            padding: 0;
            display: flex;
        }

        .nav-menu li {
            margin-right: 20px; /* Adjust the spacing between tabs */
        }

        .nav-menu li:last-child {
            margin-right: 0; /* Remove right margin from the last tab */
        }

        .nav-menu a {
            text-decoration: none;
            color: white;
            margin: 55px 0 0 ;
            font-size: 20px;
        }

        /* Highlight the active tab, for example, "Home" */
        .nav-menu a:hover,
        .nav-menu a:focus,
        .nav-menu a:active,
        .nav-menu .active {
            color: #007bff;
        }

        .banner {
            background-size: contain;
            background-repeat: no-repeat;
            background-position: right top;
            height: 300px;
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

    </style>
    <%
        String currentPage = "home"; // Change this variable in each JSP file
    %>
</head>
<body>
<header>
    <img src="logo.png" alt="Logo" class="logo">
    <nav>
        <ul class="nav-menu">
            <li class="<%= currentPage.equals("home") ? "active" : "" %>"><a href="home.jsp">home</a></li>
            <li class="<%= currentPage.equals("transaction") ? "active" : "" %>"><a href="transaction.jsp">Transaction history</a></li>
            <li class="<%= currentPage.equals("account") ? "active" : "" %>"><a href="account.jsp">account</a></li>
            <li class="<%= currentPage.equals("help") ? "active" : "" %>"><a href="help.jsp">Help</a></li>
            <li class="<%= currentPage.equals("contact") ? "active" : "" %>"><a href="contact.jsp">Contact Us</a></li>
        </ul>
    </nav>
</header>

<div class="banner">
</div>

<div class="centered-button-container">
    "balance"
</div>

</body>
</html>
