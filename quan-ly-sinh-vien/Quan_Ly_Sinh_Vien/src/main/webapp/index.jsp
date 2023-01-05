<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<body>

<table class="table-header" style=" margin-top: 30px !important">
    <tr>
        <td>
            <h2 style="color: darkblue">Quản lý sinh viên</h2>
        </td>
    </tr>

    <tr>
        <td>
            <div class="input-group mb-3">
                <a href="create.jsp" class="btn btn-primary">Create Student</a>
            </div>
        </td>
        <td>
            <form action="ServletSearch">
                <div class="input-group mb-3">

                    <input type="text" class="form-control" name="search" placeholder="Search Student name">
                    <button class="btn btn-success" type="submit">Go</button>

                </div>
            </form>
        </td>
    </tr>
</table>

<div class="all-packages-container">
    <table class="table table-striped" border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date Of Birth</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Opption</th>
            <th>Opption</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${students}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.dateOfBirth}</td>
                <td>${p.address}</td>
                <td>${p.phoneNumber}</td>
                <td>${p.email}</td>
                <td><a href="ServletEdit?id=${p.id}" class="btn btn-warning">Edit</a></td>
                <td><a href="ServletDelete?id=${p.id}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<p id="hienThiThongBao"></p>
</body>
</html>
