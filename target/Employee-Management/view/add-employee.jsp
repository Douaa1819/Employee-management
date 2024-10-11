<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Employee</title>
</head>
<body>
<h1>Add Employee</h1>
<form action="employee?action=add" method="post">
  <label>Name:</label>
  <input type="text" name="name" required><br>

  <label>Email:</label>
  <input type="email" name="email" required><br>

  <label>Department:</label>
  <input type="text" name="department" required><br>

  <label>Position:</label>
  <input type="text" name="position" required><br>

  <label>Address:</label>
  <input type="text" name="address" required><br>

  <label>Phone Number:</label>
  <input type="tel" name="phoneNumber" required><br>

  <label>Salary:</label>
  <input type="number" name="salary" step="0.01" required><br>

  <label>Sold Conge:</label>
  <input type="text" name="soldConge" required><br>

  <label>Social Security Number:</label>
  <input type="text" name="socialSecurityNumber" required><br>

  <input type="submit" value="Add Employee">
</form>

<a href="employee?action=list">Back to List</a>
</body>
</html>
