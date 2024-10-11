package org.employeemanagement.repository;


import jakarta.persistence.EntityManager;
import org.employeemanagement.model.Recruiter;
import org.employeemanagement.repository.interfaces.RecruiterRepository;
import org.employeemanagement.utils.JpaUtil;

public class RecruiterRepositoryImpl implements RecruiterRepository {

    @Override
    public Recruiter findById(Long id) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            Recruiter recruiter = entityManager.find(Recruiter.class, id);
            entityManager.getTransaction().commit();
            return recruiter;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }}