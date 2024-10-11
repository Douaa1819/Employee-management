<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
    <link rel="stylesheet" href="./resources/css/style.css">
    <title>List of Employees</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- For responsiveness -->

</head>
<body>
<c:if test="${not empty sessionScope.successMessage}">
    <div class="flash-message success">${sessionScope.successMessage}</div>
    <c:remove var="successMessage" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.errorMessage}">
    <div class="flash-message error">${sessionScope.errorMessage}</div>
    <c:remove var="errorMessage" scope="session"/>
</c:if>

<div class="container">

    <h1> <i class="fas fa-users"></i> Employee List</h1>
    <div class="add-new-btn">
        <a href="employee?action=add" class="action-btn add-btn"><i class="fas fa-plus-circle"></i> Add New Employee</a>
    </div>
    <table class="styled-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Position</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.department}</td>
                <td>${employee.position}</td>
                <td>
                    <a href="employee?action=edit&id=${employee.id}" class="action-btn edit-btn"><i class="fas fa-edit"></i> Edit</a>
                    <a href="employee?action=delete&id=${employee.id}" class="action-btn delete-btn"><i class="fas fa-trash-alt"></i> Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
