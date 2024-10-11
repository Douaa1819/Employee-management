package org.employeemanagement.service;

import org.employeemanagement.model.Recruiter;
import org.employeemanagement.repository.RecruiterRepositoryImpl;
import org.employeemanagement.repository.interfaces.RecruiterRepository;
import org.employeemanagement.service.interfaces.RecruiterService;

public class RecruiterServiceImpl implements RecruiterService {
    private RecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = new RecruiterRepositoryImpl();
    }

    @Override
    public Recruiter findById(Long id) {
        return recruiterRepository.findById(id);
    }

}