<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/27/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Student</h1>
<form method="post">
    <input name="studentId" placeholder="nhập id" value="${p.id}" readonly><br>
    <input name="name" placeholder="nhập name" value="${p.name}"><br>
    <input name="dateOfBirth" placeholder="nhập age" value="${p.dateOfBirth}"><br>
    <input name="address" placeholder="nhập address" value="${p.address}"><br>
    <input name="phoneNumber" placeholder="nhập sdt" value="${p.phoneNumber}"><br>
    <input name="email" placeholder="nhập sdt" value="${p.email}"><br>

    <button type="submit">Edit</button>
</form>
</body>
</html>
