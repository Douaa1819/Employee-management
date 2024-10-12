<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="./resources/css/cartsJob.css">
    <title>Edit Job Offer</title>
</head>
<body>
<div class="container">
    <h2>Edit Job Offer</h2>

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <form action="joboffre" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${jobOffer.id}">
        <input type="hidden" name="recruiter_id" value="14">

        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" value="${jobOffer.title}" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <textarea name="description" id="description" class="form-control" required>${jobOffer.description}</textarea>
        </div>

        <div class="form-group">
            <label for="postDate">Post Date</label>
            <input type="date" name="postDate" id="postDate" value="${jobOffer.postDate}" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <select name="status" id="status" class="form-control" required>
                <option value="Open" ${jobOffer.status == 'Open' ? 'selected' : ''}>Open</option>
                <option value="Closed" ${jobOffer.status == 'Closed' ? 'selected' : ''}>Closed</option>
            </select>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-edit"></i> Update Job Offer
            </button>
        </div>
    </form>

    <div>
        <a href="joboffre?action=list" class="back-link">Back to Job Offers List</a>
    </div>
</div>
</body>
</html>
