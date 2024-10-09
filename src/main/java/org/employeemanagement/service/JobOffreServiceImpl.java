package org.employeemanagement.service;

import org.employeemanagement.model.JobOffer;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.service.interfaces.JobOffreService;

import java.util.List;

public class JobOffreServiceImpl implements JobOffreService {
    private JobOffreRepository jobOffreRepository;

    @Override
    public JobOffer addJobOffer(JobOffer jobOffer) {
    return jobOffreRepository.save(jobOffer);
    }

    @Override
    public JobOffer getJobOfferById(Long id) {
    return jobOffreRepository.findById(id);
    }

    @Override
    public List<JobOffer> getAllJobOffers() {
        return jobOffreRepository.findAll();

    }


    @Override
    public void deleteJobOffer(Long id) {
        jobOffreRepository.delete(id);

    }
}
