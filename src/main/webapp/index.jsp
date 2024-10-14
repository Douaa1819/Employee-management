<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page d'Accueil - Gestion de l'Entreprise</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<div class="container">
    <h1 class="title">Gestion de l'Entreprise</h1>
    <div class="card-container">

        <div class="card" style="background-color: #4CAF50;">
            <a href="/Employee-Management/employee">
                <span class="icon"><i class="fas fa-user-tie"></i></span>
                <h2>Gestion des Employes</h2>
            </a>
        </div>

        <div class="card" style="background-color: #f44336;">
            <a href="/Employee-Management/joboffre">
                <span class="icon"><i class="fas fa-briefcase"></i></span>
                <h2>Gestion des Jobs</h2>
            </a>
        </div>

        <div class="card" style="background-color: #2196F3;">
            <a href="/Employee-Management/application">
                <span class="icon"><i class="fas fa-user-graduate"></i></span>
                <h2>Candidats</h2>
            </a>
        </div>

        <div class="card" style="background-color: #8d21f3;">
            <a href="/Employee-Management/candidate">
                <span class="icon"><i class="fas fa-user-tie"></i></span>
                <h2>RH</h2>
            </a>
        </div>

        <div class="card" style="background-color: #FF9800;">
            <a href="/Employee-Management/error-page.jsp">
                <span class="icon"><i class="fas fa-sun"></i></span>
                <h2>Gestion des Conges</h2>
            </a>
        </div>

    </div>
</div>

<script src="js/home.js"></script>
</body>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Arial', sans-serif;
        background-color: #121212;
        color: #FFFFFF;
    }

    h1 {
        text-align: center;
        margin-top: 20px;
        color: #FFFFFF;
    }

    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    .card-container {
        display: flex;
        justify-content: space-around;
        width: 80%;
        flex-wrap: wrap;
    }

    .card {
        width: 250px;
        height: 200px;
        margin: 20px;
        border-radius: 10px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        transition: transform 0.3s ease;
    }

    .card a {
        text-decoration: none;
        color: #FFFFFF;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .card h2 {
        margin-top: 10px;
        font-size: 20px;
    }

    .icon {
        font-size: 50px;
    }

    .card:hover {
        transform: scale(1.05);
    }

    body.dark-mode {
        background-color: #1E1E1E;
        color: #FFFFFF;
    }
</style>
</html>
