package org.employeemanagement.service;


import jakarta.transaction.Transactional;
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

    @Override
    public List<ApplicationJobOffer> findByStatus(Boolean status) {
        return applicationJobOfferRepository.findByStatus(status);
    }
    @Override
    public void update(ApplicationJobOffer applicationJobOffer) {
        applicationJobOfferRepository.update(applicationJobOffer);
    }

    @Override
    public void acceptApplication(Long applicationId, Long jobOfferId) {
        applicationJobOfferRepository.acceptApplication(applicationId, jobOfferId);
    }
    @Override
    public ApplicationJobOffer findByJobOfferIdAndApplicationId(Long jobOfferId, Long applicationId) {
        return applicationJobOfferRepository.findByApplicationIdAndJobOfferId(jobOfferId, applicationId);
    }
}