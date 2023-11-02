<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>

        #search_tf {
            margin-top: 12px;
            margin-left: 30%;
            width: 130px;
            border: 1px solid black;
        }

        label {
            font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
            "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
        }

        .main {
            margin: auto;
            border: 1px solid black;
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
            <li><a href="Register.jsp">Create Account</a></li>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/AdminServlet">
                    <input type="text" name="search" id="search_tf" placeholder="Search"/>
                </form>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="main">
    <c:if test="${not empty errorMessage}">
    <p style="text-align: center;
            color: red;
            padding: 10px;
            font-size: 14px;">${errorMessage}</p>
    </c:if>
</div>
</body>
</html>