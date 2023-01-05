<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/27/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<body>
<h1>Create New Student</h1>
<form method="post" action="show">
  <input name="studentId" placeholder="nhập id" class="form-control"><br>
  <input name="name" placeholder="nhập name" class="form-control"><br>
  <input name="dateOfBirth" placeholder="nhập ngay sinh" class="form-control"><br>
  <input name="address" placeholder="nhập địa chi" class="form-control"><br>
  <input name="phoneNumber" placeholder="nhập sdt" class="form-control"><br>
  <input name="email" placeholder="nhập email" class="form-control"><br>
  <input name="className" placeholder="nhập id lớp" class="form-control"><br>

  <button type="submit">Create</button>
</form>
</body>
</html>
