
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://jakarta.apache.org/taglibs/standard/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>List of Employees</title>
</head>

<body>
<h1>Employees</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Position</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.department}</td>
            <td>${employee.position}</td>
            <td>
                <a href="employee?action=edit&id=${employee.id}">Edit</a> |
                <a href="employee?action=delete&id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="view/add-employee.jsp">Add New Employee</a>
</body>
</html>
