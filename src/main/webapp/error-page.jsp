<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Something Went Wrong</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #121212;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #fff;
            overflow: hidden;
        }
        .container {
            text-align: center;
            background: rgba(50, 50, 50, 0.9);
            padding: 3rem;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            position: relative;
            overflow: hidden;
        }
        h1 {
            font-size: 48px;
            margin: 0;
            animation: fadeIn 1s;
            color: #ff69b4;
        }
        p {
            font-size: 20px;
            margin: 1rem 0;
            animation: fadeIn 1.5s;
            color: #f0f0f0;
        }
        a {
            text-decoration: none;
            color: #ff69b4;
            font-weight: bold;
            transition: color 0.3s;
        }
        a:hover {
            color: #ffcc00;
        }
        .emoji {
            font-size: 100px;
            animation: bounce 1s infinite;
        }
        .border-animation {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            border: 10px solid #ff69b4;
            border-radius: 20px;
            animation: pulse 2s infinite;
            z-index: -1;
        }
        @keyframes bounce {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-20px); }
        }
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        @keyframes pulse {
            0% { border-color: rgba(255, 105, 180, 1); }
            50% { border-color: rgba(255, 105, 180, 0.5); }
            100% { border-color: rgba(255, 105, 180, 1); }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="border-animation"></div>
    <div class="emoji">💔</div>
    <h1>Douaa, something went wrong!</h1>
    <p>Try to fix something in the application.</p>
    <p>Please try again later.</p>
    <p>If you think this is a mistake, please <a href="mailto:douaachemnane@gmail.com">contact support</a>.</p>
    <p><a href="/">Return to Homepage</a></p>
</div>
<script>
    const quotes = [
        "Don't worry, Douaa! Every problem has a solution!",
        "Keep your head up! You're doing great, Douaa!",
        "Mistakes are proof that you're trying, Douaa!",
        "You've got this, Douaa! Just keep going!",
        "Every setback is a setup for a comeback!"
    ];
    const randomQuote = quotes[Math.floor(Math.random() * quotes.length)];
    const quoteParagraph = document.createElement('p');
    quoteParagraph.textContent = randomQuote;
    document.querySelector('.container').appendChild(quoteParagraph);
</script>
</body>
</html>
