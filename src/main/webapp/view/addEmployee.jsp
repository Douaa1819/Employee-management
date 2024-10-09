<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Employé</title>
</head>
<body>
<h1>Ajouter un Nouvel Employé</h1>
<form action="employees" method="post">
    <label for="name">Nom :</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="email">Email :</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required>
    <br>
    <button type="submit">Ajouter</button>
</form>
<a href="employees">Retour à la liste des employés</a>
</body>
</html>
