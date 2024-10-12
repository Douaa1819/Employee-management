package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.ApplicationJobOffer;

import java.util.List;

public interface ApplicationJobOfferService {
    void save(ApplicationJobOffer applicationJobOffer);
    List<ApplicationJobOffer> findAll();
    ApplicationJobOffer findById(Long id);
    void delete(Long id);
}
