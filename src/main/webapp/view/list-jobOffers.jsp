<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
    <link rel="stylesheet" href="./resources/css/style2.css">
    <title>Job Offers Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">

    <h2><i class="fas fa-briefcase"></i> Job Offers Management</h2>

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <div class="btn-container">
        <a href="joboffre?action=add" class="btn btn-primary"><i class="fas fa-plus-circle"></i> Add Job Offer</a>
    </div>


    <div class="job-offers-container">
        <c:if test="${empty jobOffers}">
            <div class="alert alert-warning">No job offers found.</div>
        </c:if>

        <c:forEach var="jobOffer" items="${jobOffers}">
            <div class="job-offer-card">
                <h3>${jobOffer.title}</h3>
                <p class="posted-date"><strong>Posted on:</strong> ${jobOffer.postDate}</p>
                <p>${jobOffer.description}</p>
                <p>
                    <span style="color: ${jobOffer.status == 'Open' ? 'red' : 'green'}; font-weight: bold;">
                            ${jobOffer.status == 'Open' ? 'Inactive' : 'Active'}
                    </span>
                </p>

                <div class="card-actions">
                    <a href="joboffre?action=edit&id=${jobOffer.id}" class="btn btn-secondary"><i class="fas fa-edit"></i> Edit</a>
                    <a href="joboffre?action=delete&id=${jobOffer.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this job offer?');"><i class="fas fa-trash-alt"></i> Delete</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
