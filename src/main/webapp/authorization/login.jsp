<%--
  Created by IntelliJ IDEA.
  User: Цымбалюк Сергей
  Date: 17.05.2016
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3> Please enter your login and password or <a href="/registration">Sign up,</a>


<form action="login" method="POST">
    <input type="text" name="login">
    <p></p>
    <input type="password" name="password">
    <p></p>
    <input type="submit" value="login" />
</form>
    ${message}
<p></p>

</body>
</html>
