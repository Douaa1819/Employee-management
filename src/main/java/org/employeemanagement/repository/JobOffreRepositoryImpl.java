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
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(jobOffer);
            entityManager.getTransaction().commit();
            return jobOffer;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error while adding job offer", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<JobOffer> findAll() {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM JobOffer e", JobOffer.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des offres d'emploi", e);
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

            JobOffer existingJobOffer = entityManager.find(JobOffer.class, jobOffer.getId());
            if (existingJobOffer != null) {
                existingJobOffer.setTitle(jobOffer.getTitle());
                existingJobOffer.setDescription(jobOffer.getDescription());
                existingJobOffer.setStatus(jobOffer.isStatus());

                entityManager.merge(existingJobOffer);
                entityManager.getTransaction().commit();
                return existingJobOffer;
            } else {
                System.out.println("L'offre d'emploi avec l'ID " + jobOffer.getId() + " n'existe pas.");
                return null;
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la mise à jour de l'offre d'emploi", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


}
