package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.JobOffer;

import java.util.List;

public interface JobOffreService {

    JobOffer addJobOffer(JobOffer employee);
    JobOffer getJobOfferById(Long id);
    List<JobOffer> getAllJobOffers();
    JobOffer updateJobOffer(JobOffer employee);
    void deleteJobOffer(Long id);
}
