package org.employeemanagement.service;

import org.employeemanagement.model.Application;
import org.employeemanagement.repository.interfaces.ApplicationRepository;
import org.employeemanagement.service.interfaces.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application save(Application application) {
       return applicationRepository.save(application);
    }

    @Override
    public Application findById(Long id) {
        return applicationRepository.findById(id);
    }
}
