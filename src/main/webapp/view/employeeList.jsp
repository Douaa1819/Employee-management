<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Employés</title>
</head>
<body>
<h1>Liste des Employés</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>
                <!-- deri (modifier, supprimer)-->
            </td>
        </tr>
    </c:forEach>
</table>
<a href="views/addEmployee.jsp">Ajouter un Employé</a>
</body>
</html>
