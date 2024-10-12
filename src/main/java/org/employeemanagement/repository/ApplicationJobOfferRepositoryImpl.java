package org.employeemanagement.repository;

import org.employeemanagement.model.ApplicationJobOffer;
import org.employeemanagement.repository.interfaces.ApplicationJobOfferRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
    public ApplicationJobOffer findById(Long id) {
        return entityManager.find(ApplicationJobOffer.class, id);
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
}