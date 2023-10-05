<%@ page import="uts.bank.Model.account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frontline Bank</title>
    <style>
        .balance-box {
            background-color: #f5f5f5;
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            margin-top: 20px;
        }

        #balance-amount {
            font-size: 24px;
            color: #007bff; /* or the color you prefer for the balance amount */
        }

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

        p {
            font-size: 18px;
        }


    </style>
    <%
        String currentPage = "home";
        account email = (account) session.getAttribute("acc");
        String name = (String) session.getAttribute("Fname");
    %>
    <script>
        function confirmLogout() {
            var confirmResult = confirm("Are you sure you want to log out?");
            if (confirmResult) {
                // Redirect the user to the logout page or perform logout actions
                window.location.href = "login.jsp"; // Change to the actual logout page
            }
        }
    </script>

</head>
<body>
<header>
    <img src="logo.png" alt="Logo" class="logo">
    <nav>
        <ul class="nav-menu">
            <li class="<%= currentPage.equals("home") ? "active" : "" %>"><a href="home.jsp">Home</a></li>
            <li class="<%= currentPage.equals("account") ? "active" : "" %>"><a href="account.jsp">Account</a></li>
            <li class="<%= currentPage.equals("transaction") ? "active" : "" %>"><a href="transaction.jsp">Transaction history</a></li>
            <li class="<%= currentPage.equals("help") ? "active" : "" %>"><a href="help.jsp">Help</a></li>
            <li class="<%= currentPage.equals("Logout") ? "active" : "" %>" >
                <a href="#" onclick="confirmLogout();">Logout</a>
            </li>
            <span style="color: white; font-size: 20px;">Welcome, <%= name %></span>

        </ul>

    </nav>
</header>
<div id="balance-box" class="balance-box">
    <p>Your Account Balance:</p>
    <span id="balance-amount">$ <%=email.getBalance() %> AUD</span>
</div>

</body>
</html>
