package org.employeemanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.employeemanagement.model.Employee;
import org.employeemanagement.repository.interfaces.EmployeeRepository;
import org.employeemanagement.utils.JpaUtil;

import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee save(Employee employee) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de l'ajout de l'employé", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Employee findById(Long id) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            return entityManager.find(Employee.class, id);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Employee update(Employee employee) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Employee existingEmployee = entityManager.find(Employee.class, employee.getId());
            if (existingEmployee != null) {
                entityManager.merge(employee);
                entityManager.getTransaction().commit();
                return employee;
            } else {
                System.out.println("L'employé avec l'ID " + employee.getId() + " n'existe pas.");
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

    @Override
    public List<Employee> findAll() {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            return query.getResultList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Employee employee = entityManager.find(Employee.class, id);
            if (employee != null) {
                entityManager.remove(employee);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("L'employé avec l'ID " + id + " n'existe pas.");
            }
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la suppression de l'employé", e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}