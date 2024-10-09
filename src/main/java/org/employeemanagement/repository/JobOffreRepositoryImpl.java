package org.employeemanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.employeemanagement.model.Employee;
import org.employeemanagement.model.JobOffer;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.utils.JpaUtil;

import java.util.List;

public class JobOffreRepositoryImpl implements JobOffreRepository {

    @Override
    public JobOffer save(JobOffer jobOffer) {
        EntityManager entityManager = null;
        try {
            entityManager= JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(jobOffer);
            entityManager.getTransaction().commit();
            return jobOffer;

        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de l'ajout de offre de travaille", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    @Override
    public List<JobOffer> findAll() {
      EntityManager entityManager = null;
      entityManager= JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
      try {
          entityManager.getTransaction().begin();
          Query query = entityManager.createQuery("from JobOffer");
          List<JobOffer> jobOffers = query.getResultList();
          entityManager.getTransaction().commit();
          return jobOffers;
       } catch (Exception e) {
        if (entityManager != null && entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        throw new RuntimeException("Erreur lors de get tous les offre", e);
    } finally {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}


    @Override
    public JobOffer findById(Long id) {
   EntityManager entityManager = null;
   entityManager= JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
   try {
       entityManager.getTransaction().begin();
       JobOffer jobOffer = entityManager.find(JobOffer.class, id);
       entityManager.getTransaction().commit();
       return jobOffer;

   } finally {
       if (entityManager != null && entityManager.isOpen()) {
           entityManager.close();
       }
   }
    }


    @Override
    public void delete(Long id) {
        EntityManager entityManager = null;
        entityManager= JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            JobOffer jobOffer = entityManager.find(JobOffer.class, id);
            entityManager.remove(jobOffer);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la suppression de l'offre", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }


    }

    @Override
    public JobOffer update(JobOffer jobOffer) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Employee existingEmployee = entityManager.find(Employee.class, jobOffer.getId());
            if (existingEmployee != null) {
                entityManager.merge(jobOffer);
                entityManager.getTransaction().commit();
                return jobOffer;
            } else {
                System.out.println("L'employé avec l'ID " + jobOffer.getId() + " n'existe pas.");
                return null;
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la mise à jour de l'employé", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
