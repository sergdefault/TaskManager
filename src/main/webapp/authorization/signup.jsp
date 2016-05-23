--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Registration</title>
</head>
<body>
<h3> Please enter your login and password  </h3>
</p>

<form action="create" method="POST">
  <input type="text" name="login">
  <p></p>
  <input type="password" name="password">
  <p></p>
  <input type="submit" value="create" />
</form>
<p></p>
${message}

</body>
</html>
