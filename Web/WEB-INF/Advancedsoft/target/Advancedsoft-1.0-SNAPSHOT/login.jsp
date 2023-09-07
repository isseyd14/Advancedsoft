<%--
  Created by IntelliJ IDEA.
  User: issey
  Date: 7/09/2023
  Time: 4:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<h2>Login Page</h2>

<%-- Check if there's an error message to display --%>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<form action="LoginServlet" method="POST">
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br><br>

    <label for="Password">Password:</label>
    <input type="Password" id="Password" name="Password" required><br><br>

</form>
<form action="Register.jsp" >
    <button type="submit">Register Account</button>
</form>
</body>
</html>





