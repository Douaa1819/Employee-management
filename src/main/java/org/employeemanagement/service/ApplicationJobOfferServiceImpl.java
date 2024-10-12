package org.employeemanagement.service;


import org.employeemanagement.model.ApplicationJobOffer;
import org.employeemanagement.repository.ApplicationJobOfferRepositoryImpl;
import org.employeemanagement.repository.interfaces.ApplicationJobOfferRepository;
import org.employeemanagement.service.interfaces.ApplicationJobOfferService;

import java.util.List;

public class ApplicationJobOfferServiceImpl implements ApplicationJobOfferService {
    private  ApplicationJobOfferRepository applicationJobOfferRepository;

    public ApplicationJobOfferServiceImpl() {
        this.applicationJobOfferRepository = new ApplicationJobOfferRepositoryImpl();
    }

    @Override
    public void save(ApplicationJobOffer applicationJobOffer) {
        applicationJobOfferRepository.save(applicationJobOffer);
    }

    @Override
    public List<ApplicationJobOffer> findAll() {
        return applicationJobOfferRepository.findAll();
    }

    @Override
    public ApplicationJobOffer findById(Long id) {
        return applicationJobOfferRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        applicationJobOfferRepository.delete(id);
    }
}