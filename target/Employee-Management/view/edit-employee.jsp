<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit Employee</title>
</head>
<body>
<h1>Edit Employee</h1>
<form action="employee?action=update" method="post">
  <input type="hidden" name="id" value="${employee.id}">

  <label>Name:</label>
  <input type="text" name="name" value="${employee.name}" required><br>

  <label>Email:</label>
  <input type="email" name="email" value="${employee.email}" required><br>

  <label>Department:</label>
  <input type="text" name="department" value="${employee.department}" required><br>

  <label>Position:</label>
  <input type="text" name="position" value="${employee.position}" required><br>

  <label>Address:</label>
  <input type="text" name="address" value="${employee.address}" required><br>

  <label>Phone Number:</label>
  <input type="tel" name="phoneNumber" value="${employee.phoneNumber}" required><br>

  <label>Salary:</label>
  <input type="number" name="salary" step="0.01" value="${employee.salary}" required><br>

  <label>Sold Conge:</label>
  <input type="text" name="soldConge" value="${employee.soldConge}" required><br>

  <label>Social Security Number:</label>
  <input type="text" name="socialSecurityNumber" value="${employee.socialSecurityNumber}" required><br>

  <input type="submit" value="Update Employee">
</form>

<a href="employee?action=list">Back to List</a>
</body>
</html>
