<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/application.css">
    <title>Job Applications</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome for icons -->

</head>
<body>
<h1>🌟 Job Applications 🌟</h1>

<div class="welcome-message">
    Welcome to your next career opportunity! We are excited to assist you in your job search.
</div>

<div class="image-container">
    <img src="https://emeritus.org/in/wp-content/uploads/sites/3/2022/10/9-Things-to-Keep-in-Mind-When-Applying-for-Job.jpg.optimal.jpg" alt="Job Application Image" style="width: 100%; max-width: 400px; border-radius: 10px;">
</div>

<c:if test="${not empty message}">
    <div class="flash-message success-message" style="display: block;">${message}</div>
</c:if>
<c:if test="${not empty errorMessage}">
    <div class="flash-message error-message" style="display: block;">${errorMessage}</div>
</c:if>
<c:if test="${not empty successMessage}">
    <div class="flash-message success-message" style="display: block;">${successMessage}</div>
</c:if>

<div class="job-container">
    <c:forEach var="jobOffer" items="${jobOffers}">
        <div class="job-card">
            <div class="job-title">${jobOffer.title}</div>
            <div class="job-description">${jobOffer.description}</div>
            <a href="javascript:void(0);" class="apply-btn" onclick="openApplyModal(${jobOffer.id})">
                <i class="fas fa-paper-plane"></i> Apply Now
            </a>
        </div>
    </c:forEach>
</div>

<div id="applyModal" style="display:none;">
    <div class="modal-content">
        <div class="modal-form">
            <span class="close" onclick="closeApplyModal()">&times;</span>
            <h2>Apply for Job</h2>
            <form action="application" method="post" enctype="multipart/form-data">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br><br>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br><br>

                <label for="birthDate">Date of Birth:</label>
                <input type="date" id="birthDate" name="birthDate" required><br><br>

                <label for="skills">Skills:</label>
                <input type="text" id="skills" name="skills" required><br><br>

                <label for="document">Upload Document:</label>
                <input type="file" id="document" name="document" required><br><br>

                <input type="hidden" id="jobOfferId" name="jobOfferId" value="">

                <input type="submit" value="Submit" class="apply-btn">
            </form>
        </div>
    </div>
</div>

<script>
    function openApplyModal(jobOfferId) {
        document.getElementById('jobOfferId').value = jobOfferId;
        document.getElementById('applyModal').style.display = "block";
    }

    function closeApplyModal() {
        document.getElementById('applyModal').style.display = "none";
    }


    window.onload = function() {
        const flashMessages = document.querySelectorAll('.flash-message');
        flashMessages.forEach(msg => {
            if (msg.style.display === 'block') {
                setTimeout(() => {
                    msg.style.opacity = '0';
                    setTimeout(() => msg.style.display = 'none', 500);
                }, 3000);
            }
        });
    };
</script>
</body>
</html>
