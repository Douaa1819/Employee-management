package org.employeemanagement.repository.interfaces;

import org.employeemanagement.model.ApplicationJobOffer;

import java.util.List;

public interface ApplicationJobOfferRepository {
    void save(ApplicationJobOffer applicationJobOffer);
    List<ApplicationJobOffer> findAll();
    ApplicationJobOffer findById(Long id);
    void delete(Long id);
}
