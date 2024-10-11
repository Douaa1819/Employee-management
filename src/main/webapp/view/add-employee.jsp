<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <link rel="stylesheet" href="./resources/css/cartForme.css">
  <title>Add Employee</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

<div class="container">
  <c:if test="${not empty sessionScope.successMessage}">
    <div class="flash-message success">${sessionScope.successMessage}</div>
    <c:remove var="successMessage" scope="session"/>
  </c:if>

  <c:if test="${not empty sessionScope.errorMessage}">
    <div class="flash-message error">${sessionScope.errorMessage}</div>
    <c:remove var="errorMessage" scope="session"/>
  </c:if>

  <h1><i class="fas fa-user-plus"></i> Add Employee</h1>
  <form action="employee?action=add" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="birthDate">Birthday:</label>
    <input type="date" id="birthDate" name="birthDate" required>

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" required>

    <label for="position">Position:</label>
    <input type="text" id="position" name="position" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>

    <label for="phoneNumber">Phone Number:</label>
    <input type="tel" id="phoneNumber" name="phoneNumber" required>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>

    <label for="soldConge">Sold Conge:</label>
    <input type="text" id="soldConge" name="soldConge" required>

    <label for="socialSecurityNumber">Social Security Number:</label>
    <input type="text" id="socialSecurityNumber" name="socialSecurityNumber" required>
    <input type="submit" class="add" value="Add Employee">
  </form>

  <a href="employee?action=list">Back to List</a>
</div>
</body>
</html>
