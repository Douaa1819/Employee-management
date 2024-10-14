package org.employeemanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.employeemanagement.model.Application;
import org.employeemanagement.repository.interfaces.ApplicationRepository;

import java.util.List;

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

    @Override
    public List<Application> findDistinctByCompetencies(String competency) {
        return entityManager.createQuery(
                        "SELECT DISTINCT a FROM Application a WHERE a.skills LIKE :competency", Application.class)
                .setParameter("competency", "%" + competency + "%")
                .getResultList();
    }

    @Override
    public List<String> findAllSkills() {
        return entityManager.createQuery(
                        "SELECT DISTINCT a.skills FROM Application a", String.class)
                .getResultList();
    }

    @Override
    public List<Application> findAll() {
        TypedQuery<Application> query = entityManager.createQuery("SELECT a FROM Application a", Application.class);
        return query.getResultList();
    }
}