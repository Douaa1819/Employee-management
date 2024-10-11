package org.employeemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.employeemanagement.exception.InvalidInputException;
import org.employeemanagement.model.JobOffer;
import org.employeemanagement.model.Recruiter;
import org.employeemanagement.repository.JobOffreRepositoryImpl;
import org.employeemanagement.repository.RecruiterRepositoryImpl;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.repository.interfaces.RecruiterRepository;
import org.employeemanagement.service.JobOffreServiceImpl;
import org.employeemanagement.service.RecruiterServiceImpl;
import org.employeemanagement.service.interfaces.JobOffreService;
import org.employeemanagement.service.interfaces.RecruiterService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/joboffre")
public class JobOfferServlet extends HttpServlet {

    private JobOffreRepository jobOffreRepository;
    private JobOffreService jobOffreService ;
    private RecruiterService recruiterService;
    private RecruiterRepository recruiterRepository;

    @Override
    public void init() {
        jobOffreRepository = new JobOffreRepositoryImpl();
        jobOffreService = new JobOffreServiceImpl(jobOffreRepository);
        recruiterRepository = new RecruiterRepositoryImpl();
        recruiterService = new RecruiterServiceImpl(recruiterRepository);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteJobOffre(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            default:
                listJobOffres(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "add";

        switch (action) {
            case "edit":
                updateJobOffre(req, resp);
                break;
            case "add":
                addFormeJobOffre(req, resp);
                break;
            default:
                listJobOffres(req, resp);
                break;
        }
    }



    private void listJobOffres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<JobOffer> jobOffers = jobOffreService.getAllJobOffers();
            System.out.println("Number of job offers retrieved: " + jobOffers.size());

            request.setAttribute("jobOffers", jobOffers);
            request.getRequestDispatcher("view/list-jobOffers.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Error while displaying job offers: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error-page.jsp");
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "Job offer ID is missing.");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
            return;
        }

        try {
            Long id = Long.parseLong(idParam);
            JobOffer jobOffer = jobOffreService.getJobOfferById(id);
            request.setAttribute("jobOffer", jobOffer);
            request.getRequestDispatcher("view/edit-jobOffer.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("errorMessage", "Invalid job offer ID.");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Error while fetching job offer: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
        }
    }


    private void deleteJobOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            jobOffreService.deleteJobOffer(id);
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete job offer");
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/add-jobOffer.jsp").forward(request, response);
    }

    private void addFormeJobOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JobOffer jobOffer = extractJobOfferFromRequest(request);

            System.out.println("Job Offer to add: " + jobOffer);

            jobOffreService.addJobOffer(jobOffer);
            request.getSession().setAttribute("successMessage", "The job offer was added successfully!");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Error while adding job offer: " + e.getMessage() + ". Check if all fields are properly filled.");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=add");
        }
    }

    private void updateJobOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JobOffer jobOffer = extractJobOfferFromRequest(request);
            System.out.println("Job Offer ID: " + jobOffer.getId());
            System.out.println("Job Offer Title: " + jobOffer.getTitle());

            if (jobOffer.getId() == null) {
                throw new IllegalArgumentException("Job Offer ID cannot be null");
            }

            jobOffreService.updateJobOffer(jobOffer);
            request.getSession().setAttribute("successMessage", "Job offer updated successfully");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Error while updating job offer: " + e.getMessage());
            String jobId = request.getParameter("id");
            response.sendRedirect(request.getContextPath() + "/joboffre?action=edit&id=" + jobId);
        }
    }


    private JobOffer extractJobOfferFromRequest(HttpServletRequest request) {
        try {

            String title = request.getParameter("title");
            if (title == null || title.isEmpty()) {
                throw new InvalidInputException("Title cannot be empty.");
            }

            String description = request.getParameter("description");
            if (description == null || description.isEmpty()) {
                throw new InvalidInputException("Description cannot be empty.");
            }

            String postDateString = request.getParameter("postDate");
            if (postDateString == null || postDateString.isEmpty()) {
                throw new InvalidInputException("Post date cannot be empty.");
            }

            String statusString = request.getParameter("status");
            if (statusString == null || statusString.isEmpty()) {
                throw new InvalidInputException("Status cannot be empty.");
            }


            Long recruiterId;
            try {
                recruiterId = Long.parseLong(request.getParameter("recruiter_id"));
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Invalid recruiter ID.");
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date postDate = dateFormat.parse(postDateString);
            boolean status = statusString.equalsIgnoreCase("Open");

            JobOffer jobOffer = new JobOffer();
            String id = request.getParameter("id");
            if (id != null && !id.isEmpty()) {
                jobOffer.setId(Long.parseLong(id));
            }
            jobOffer.setTitle(title);
            jobOffer.setDescription(description);
            jobOffer.setPostDate(postDate);
            jobOffer.setStatus(status);

            Recruiter recruiter = recruiterService.findById(recruiterId);
            if (recruiter == null) {
                throw new InvalidInputException("Recruiter with ID: " + recruiterId + " does not exist.");
            }


            jobOffer.setRecruiter(recruiter);

            return jobOffer;

        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + e.getMessage());
        }
    }
}