<%--
  Created by IntelliJ IDEA.
  User: Цымбалюк Сергей
  Date: 21.05.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table  border="2">
    <col width="70">
    <col width="300">
    <col width="200">
    <col width="130">
    <thead>
    <tr>
        <th>Number</th>
        <th>Time</th>
        <th>Description</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allTasks}" var="task">
        <tr>
            <td><c:out value="${task.id}" /></td>
            <td><fmt:formatDate value="${task.date}" type="date" pattern="MM/dd/yyyy HH:mm:ss"/></td>
            <td><c:out value="${task.description}" /></td>
            <td><c:out value="${task.status}" /></td>
            <td><a href="view?action=edit&id=<c:out value="${task.id}"/>">Update</a></td>
            <td><a href='view?action=delete&id=<c:out value="${task.id}"/>&status=<c:out value="${task.status}"/>'> Delete </a> </td>
        </tr>
            </c:forEach>
    </tbody>
</table>
<p></p><p></p>
<H1>Create new task</H1>

<form action="add" method="GET">
    <input type="text" name="description">
    <input type="submit" value="create" />
</form>

</body>
</html>
