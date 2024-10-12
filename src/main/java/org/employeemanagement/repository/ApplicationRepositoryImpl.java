package org.employeemanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.employeemanagement.model.Application;
import org.employeemanagement.repository.interfaces.ApplicationRepository;

public class ApplicationRepositoryImpl implements ApplicationRepository {

    private EntityManager entityManager;

    public ApplicationRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("employeesmanagment").createEntityManager();
    }

    @Override
    public Application save(Application application) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(application);
        transaction.commit();
        return application;
    }

    @Override
    public Application findById(Long id) {
        return entityManager.find(Application.class, id);
    }
}