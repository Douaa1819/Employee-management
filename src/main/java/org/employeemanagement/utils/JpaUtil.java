package org.employeemanagement.utils;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static JpaUtil instance;
    private static EntityManagerFactory entityManagerFactory;

    private JpaUtil() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("employeesmanagment");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Échec de la création de l'EntityManagerFactory : " + ex);
        }
    }

    public static synchronized JpaUtil getInstance() {
        if (instance == null) {
            instance = new JpaUtil();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}