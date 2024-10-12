<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Job Applications</title>
    <style>
        /* Basic styles for the page and modal */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .modal-content {
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .modal-form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .close:hover, .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Job Applications</h1>

<c:if test="${not empty message}">
    <div style="color: green;">${message}</div>
</c:if>

<table>
    <thead>
    <!-- Display error messages -->
    <c:if test="${not empty errorMessage}">
        <tr>
            <td colspan="3" style="color: red;">${errorMessage}</td>
        </tr>
    </c:if>

    <!-- Display success messages -->
    <c:if test="${not empty successMessage}">
        <tr>
            <td colspan="3" style="color: green;">${successMessage}</td>
        </tr>
    </c:if>

    <tr>
        <th>Job Title</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="jobOffer" items="${jobOffers}">
        <tr>
            <td>${jobOffer.title}</td>
            <td>${jobOffer.description}</td>
            <td>
                <a href="javascript:void(0);" onclick="openApplyModal(${jobOffer.id})">Apply</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="applyModal" style="display:none;">
    <div class="modal-content">
        <div class="modal-form">
            <span class="close" onclick="closeApplyModal()">&times;</span>
            <h2>Apply for Job</h2>
            <form action="application" method="post" enctype="multipart/form-data">
            <label for="name">Nom:</label>
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

                <!-- Add the hidden input for jobOfferId -->
                <input type="hidden" id="jobOfferId" name="jobOfferId" value="">

                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</div>


<script>
    function openApplyModal(jobOfferId) {
        document.getElementById('jobOfferId').value = jobOfferId; // Set the job offer ID in the hidden input
        document.getElementById('applyModal').style.display = "block"; // Show the modal
    }

    function closeApplyModal() {
        document.getElementById('applyModal').style.display = "none"; // Hide the modal
    }

    // Close the modal when clicking outside of it
    window.onclick = function(event) {
        var modal = document.getElementById('applyModal');
        if (event.target === modal) {
            closeApplyModal();
        }
    }
</script>
</body>
</html>
