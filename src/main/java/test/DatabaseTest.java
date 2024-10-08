package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            // Crée l'EntityManagerFactory à partir de la persistence unit définie dans persistence.xml
            emf = Persistence.createEntityManagerFactory("company_employees");
            em = emf.createEntityManager();

            // Vérifie la connexion
            if (em.isOpen()) {
                System.out.println("La connexion à la base de données est établie avec succès !");
            } else {
                System.out.println("Échec de la connexion à la base de données.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ferme l'EntityManager et l'EntityManagerFactory
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
