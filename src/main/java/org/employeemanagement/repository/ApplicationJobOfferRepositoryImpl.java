package org.employeemanagement.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.employeemanagement.model.ApplicationJobOffer;
import org.employeemanagement.repository.interfaces.ApplicationJobOfferRepository;

import java.util.List;

public class ApplicationJobOfferRepositoryImpl implements ApplicationJobOfferRepository {
    private EntityManager entityManager;

    public ApplicationJobOfferRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("employeesmanagment").createEntityManager();
    }

    @Override
    public void save(ApplicationJobOffer applicationJobOffer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(applicationJobOffer);
        transaction.commit();
    }

    @Override
    public List<ApplicationJobOffer> findAll() {
        return entityManager.createQuery("SELECT a FROM ApplicationJobOffer a", ApplicationJobOffer.class).getResultList();
    }

    @Override
    public ApplicationJobOffer findById(Long applicationId) {
        ApplicationJobOffer appJobOffer = entityManager.find(ApplicationJobOffer.class, applicationId);
        if (appJobOffer == null) {
            System.out.println("No application found with ID: " + applicationId);
        } else {
            System.out.println("Found application: " + appJobOffer);
        }
        return appJobOffer;
    }



    @Override
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ApplicationJobOffer applicationJobOffer = findById(id);
        if (applicationJobOffer != null) {
            entityManager.remove(applicationJobOffer);
        }
        transaction.commit();
    }


    @Override
    public List<ApplicationJobOffer> findByStatus(Boolean status) {
        return entityManager.createQuery(
                        "SELECT ajo FROM ApplicationJobOffer ajo WHERE ajo.status = :status",
                        ApplicationJobOffer.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public void update(ApplicationJobOffer applicationJobOffer) {
        entityManager.merge(applicationJobOffer);
        entityManager.flush();
    }

    @Override
    public ApplicationJobOffer findByApplicationIdAndJobOfferId(Long applicationId, Long jobOfferId) {
        try {
            return entityManager.createQuery(
                            "SELECT ajo FROM ApplicationJobOffer ajo WHERE ajo.application.id = :applicationId AND ajo.jobOffer.id = :jobOfferId",
                            ApplicationJobOffer.class)
                    .setParameter("applicationId", applicationId)
                    .setParameter("jobOfferId", jobOfferId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void acceptApplication(Long applicationId, Long jobOfferId) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ApplicationJobOffer applicationJobOffer = findByApplicationIdAndJobOfferId(applicationId, jobOfferId);
            if (applicationJobOffer == null) {
                throw new RuntimeException("Candidature non trouvée.");
            }

            boolean currentStatus = applicationJobOffer.isStatus();
            applicationJobOffer.setStatus(!currentStatus);
            entityManager.merge(applicationJobOffer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

}