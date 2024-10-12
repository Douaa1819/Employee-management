package org.employeemanagement.controller;

import org.employeemanagement.model.Application;
import org.employeemanagement.model.ApplicationJobOffer;
import org.employeemanagement.model.JobOffer;
import org.employeemanagement.repository.ApplicationRepositoryImpl;
import org.employeemanagement.repository.JobOffreRepositoryImpl;
import org.employeemanagement.repository.interfaces.ApplicationRepository;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.service.ApplicationJobOfferServiceImpl;
import org.employeemanagement.service.ApplicationServiceImpl;
import org.employeemanagement.service.JobOffreServiceImpl;
import org.employeemanagement.service.interfaces.ApplicationJobOfferService;
import org.employeemanagement.service.interfaces.ApplicationService;
import org.employeemanagement.service.interfaces.JobOffreService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@MultipartConfig
@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {
    private ApplicationService applicationService;
    private ApplicationJobOfferService applicationJobOfferService;
    private JobOffreService jobOffreService;

    @Override
    public void init() throws ServletException {
        ApplicationRepository applicationRepository = new ApplicationRepositoryImpl();
        applicationService = new ApplicationServiceImpl(applicationRepository);
        jobOffreService = new JobOffreServiceImpl(new JobOffreRepositoryImpl());
        applicationJobOfferService = new ApplicationJobOfferServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entrée dans doGet de ApplicationServlet");
        try {
            List<JobOffer> jobOffers = jobOffreService.getAllJobOffers();
            request.setAttribute("jobOffers", jobOffers);
            request.getRequestDispatcher("view/applications.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Error while displaying job offers: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error-page.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String skills = request.getParameter("skills");
        Part documentPart = request.getPart("document");
        String jobOfferIdParam = request.getParameter("jobOfferId");

        // Vérification des données
        if (name == null || name.isEmpty()) {
            request.setAttribute("errorMessage", "Name is required.");
            doGet(request, response);
            return;
        }

        Long jobOfferId;
        try {
            jobOfferId = Long.parseLong(jobOfferIdParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid Job Offer ID.");
            doGet(request, response);
            return;
        }

        JobOffer jobOffer = jobOffreService.getJobOfferById(jobOfferId);
        if (jobOffer == null) {
            request.setAttribute("errorMessage", "Job Offer not found.");
            doGet(request, response);
            return;
        }


        String uploadDir = "C:/Users/ycode/Downloads/";

        Files.createDirectories(Paths.get(uploadDir));

        String fileName = documentPart.getSubmittedFileName();
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
        String uploadedFilePath = uploadDir + uniqueFileName;


        try (InputStream fileContent = documentPart.getInputStream()) {
            Path path = Paths.get(uploadedFilePath);
            Files.copy(fileContent, path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File uploaded to: " + uploadedFilePath);
        } catch (IOException e) {
            request.setAttribute("errorMessage", "Failed to save the document: " + e.getMessage());
            doGet(request, response);
            return;
        }


        Application application = new Application();
        application.setName(name);
        application.setEmail(email);
        application.setPassword(password);
        application.setSkills(skills);
        application.setDocument(uploadedFilePath);


        application = applicationService.save(application);


        ApplicationJobOffer applicationJobOffer = new ApplicationJobOffer();
        applicationJobOffer.setJobOffer(jobOffer);
        applicationJobOffer.setApplication(application);
        applicationJobOffer.setStatus(false);


        applicationJobOfferService.save(applicationJobOffer);


        request.getSession().setAttribute("successMessage", "Application submitted successfully!");
        response.sendRedirect("application");
    }
}
