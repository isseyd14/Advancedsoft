
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Card Management</h2>

<form action="add" method="post">
    <label for="cardNumber">Card Number:</label>
    <input type="text" id="cardNumber" name="cardNumber"><br><br>
    <label for="cardHolder">Card Holder:</label>
    <input type="text" id="cardHolder" name="cardHolder"><br><br>
    <label for="cardType">Card Type:</label>
    <input type="text" id="cardType" name="cardType"><br><br>
    <label for="cardExpiry">Card Expiry:</label>
    <input type="text" id="cardExpiry" name="cardExpiry"><br><br>
    <label for="cardCvv">Card CVV:</label>
    <input type="text" id="cardCvv" name="cardCvv"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
