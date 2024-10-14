package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.ApplicationJobOffer;

import java.util.List;

public interface ApplicationJobOfferService {
    void save(ApplicationJobOffer applicationJobOffer);
    List<ApplicationJobOffer> findAll();
    ApplicationJobOffer findById(Long id);
    void delete(Long id);
    List<ApplicationJobOffer> findByStatus(Boolean status);
    void update(ApplicationJobOffer applicationJobOffer);
    void acceptApplication(Long applicationId, Long jobOfferId);
    ApplicationJobOffer findByJobOfferIdAndApplicationId(Long jobOfferId, Long applicationId);
}
