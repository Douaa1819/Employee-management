package org.employeemanagement.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.employeemanagement.model.Application;
import org.employeemanagement.model.ApplicationJobOffer;
import org.employeemanagement.repository.ApplicationRepositoryImpl;
import org.employeemanagement.service.ApplicationJobOfferServiceImpl;
import org.employeemanagement.service.ApplicationServiceImpl;
import org.employeemanagement.service.interfaces.ApplicationJobOfferService;
import org.employeemanagement.service.interfaces.ApplicationService;

import java.io.IOException;
import java.util.List;

@WebServlet("/candidate")
public class CandidateServlet extends HttpServlet {

    private ApplicationService applicationService;
    private ApplicationJobOfferService applicationJobOfferService;

    @Override
    public void init() {
        applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());
        applicationJobOfferService = new ApplicationJobOfferServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            List<Application> applications = applicationService.findAll();
            request.setAttribute("applications", applications);
            List<String> skills = applicationService.findAllSkills();
            request.setAttribute("skills", skills);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("flashMessage", "Erreur lors de la récupération des candidatures.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/candidate.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String statusParam = request.getParameter("status");
        String skillsParam = request.getParameter("skills");

        Boolean status = null;
        if ("true".equals(statusParam)) {
            status = true;
        } else if ("false".equals(statusParam)) {
            status = false;
        }

        List<ApplicationJobOffer> filteredApplications = applicationJobOfferService.findByStatus(status);
        request.setAttribute("applications", filteredApplications);


        List<String> skills = applicationService.findAllSkills();
        request.setAttribute("skills", skills);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/candidate.jsp");
        dispatcher.forward(request, response);

        //fonctionne
        String applicationIdStr = request.getParameter("applicationId");
        String jobOfferIdStr = request.getParameter("jobOfferId");

        if (applicationIdStr == null || applicationIdStr.isEmpty() || jobOfferIdStr == null || jobOfferIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Les identifiants de candidature ou d'offre d'emploi ne peuvent pas être vides.");
            return;
        }

        Long applicationId = Long.parseLong(applicationIdStr);
        Long jobOfferId = Long.parseLong(jobOfferIdStr);

        String message;

        try {
            applicationJobOfferService.acceptApplication(applicationId, jobOfferId);

            boolean newStatus = applicationJobOfferService.findByJobOfferIdAndApplicationId(applicationId, jobOfferId).isStatus();
            message = newStatus ? "Candidature acceptée avec succès." : "Candidature refusée avec succès.";

            request.getSession().setAttribute("flashMessage", message);
            response.sendRedirect(request.getHeader("referer"));
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}