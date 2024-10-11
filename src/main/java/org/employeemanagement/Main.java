package org.employeemanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.employeemanagement.model.Employee;
import org.employeemanagement.model.JobOffer;
import org.employeemanagement.model.Recruiter;
import org.employeemanagement.repository.EmployeeRepositoryImpl;
import org.employeemanagement.repository.JobOffreRepositoryImpl;
import org.employeemanagement.repository.RecruiterRepositoryImpl;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.repository.interfaces.RecruiterRepository;
import org.employeemanagement.service.JobOffreServiceImpl;
import org.employeemanagement.service.RecruiterServiceImpl;
import org.employeemanagement.service.interfaces.JobOffreService;
import org.employeemanagement.service.interfaces.RecruiterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

//    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("employeesmanagment");
//    EntityManager entityManager=entityManagerFactory.createEntityManager();
//    entityManager.getTransaction().begin();
//    entityManager.getTransaction().commit();

    public static void main(String[] args) {
//       EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
//        RecruiterService recruiterService;
//        recruiterRepository = new RecruiterRepositoryImpl(); // Ensure this is initialized properly
//        recruiterService = new RecruiterServiceImpl(recruiterRepository);

        // Définir les valeurs pour le nouvel employé
//        String name = "Douaa";
//        String email = "douaa@example.com";
//        String password = "password123";
//        Date birthDate = new Date();
//        String department = "IT";
//        String position = "Developer";
//        String address = "123 Main St";
//        String phoneNumber = "555-1234";
//        double salary = 60000.0;
//        String soldConge = "10 jours";
//        String socialSecurityNumber = "123-45-6789";
//
//        Employee newEmployee = new Employee(
//                name, email, password, birthDate, department, position, address, phoneNumber, salary, soldConge, socialSecurityNumber
//        );
//
//        Employee savedEmployee = employeeRepository.save(newEmployee);
//
//        System.out.println("Employé créé : " + savedEmployee.getId() + " - " + savedEmployee.getName() + " (" + savedEmployee.getPosition() + ")");


//         2. Récupérer tous les employés
//        List<Employee> allEmployees = employeeRepository.findAll();
//        System.out.println("Liste des employés : ");
//        for (Employee employee : allEmployees) {
//            System.out.println("ID: " + employee.getId() + ", Nom: " + employee.getName());
//        }

//         3. Mettre à jour un employé
//        if (!allEmployees.isEmpty()) {
//            Employee employeeToUpdate = allEmployees.get(0); // Supposons que nous mettons à jour le premier employé
//            employeeToUpdate.setSalary(65000.0); // Mise à jour du salaire
//            employeeRepository.save(employeeToUpdate); // Enregistrer les changements
//            System.out.println("Employé mis à jour : ID: " + employeeToUpdate.getId() + ", Nouveau Salaire: " + employeeToUpdate.getSalary());
//        }

        // 4. Supprimer un employé
//       employeeRepository.delete(2L);
//
//        // Vérifier la liste après suppression
//        List<Employee> updatedEmployees = employeeRepository.findAll();
//        System.out.println("Liste des employés après suppression : ");
//        for (Employee employee : updatedEmployees) {
//            System.out.println("ID: " + employee.getId() + ", Nom: " + employee.getName());
//        }


//        Long employeeIdToUpdate = 1L; // Remplacez cela par l'ID que vous souhaitez mettre à jour
//        Employee existingEmployee = employeeRepository.findById(employeeIdToUpdate);
//
//        if (existingEmployee != null) {
//            existingEmployee.setPosition("Senior Developer");
//            existingEmployee.setSalary(75000);
//
//            employeeRepository.update(existingEmployee);
//
//            System.out.println("Mise à jour réussie pour l'employé avec ID " + existingEmployee.getId());
//        } else {
//            System.out.println("Aucun employé trouvé avec l'ID " + employeeIdToUpdate);
//        }
//    }






            ///job offre


//        JobOffreRepository jobOffreRepository = new JobOffreRepositoryImpl(); // Assurez-vous que cette classe est bien implémentée
//        JobOffreService jobOffreService = new JobOffreServiceImpl(jobOffreRepository); // Injection de dépendance // Assurez-vous que JobOffreServiceImpl est correctement implémenté.
//        Scanner scanner = new Scanner(System.in);
////
////         Ajout d'une offre d'emploi
//        System.out.println("Ajoutez une nouvelle offre d'emploi :");
//        JobOffer jobOffre = new JobOffer(); // Créer un nouvel objet JobOffre
//        System.out.print("Titre : ");
//        jobOffre.setTitle(scanner.nextLine());
//        System.out.print("Description : ");
//        jobOffre.setDescription(scanner.nextLine());
//        System.out.print("Date : ");
//        System.out.print("Date de publication (jj/MM/aaaa) : ");
//        String dateInput = scanner.nextLine();
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date postDate = dateFormat.parse(dateInput);
//
//            Recruiter recruiter = recruiterService.findById(1L);
//            jobOffre.setRecruiter(recruiter);
//            jobOffre.setPostDate(postDate);
//        } catch (ParseException e) {
//            System.out.println("Format de date invalide. La date ne sera pas définie.");
//        }
//        jobOffreService.addJobOffer(jobOffre);
//        System.out.println("Offre d'emploi ajoutée avec succès!");

//
//        System.out.println("Liste de toutes les offres d'emploi :");
//        List<JobOffer> jobOffers = jobOffreService.getAllJobOffers();
//        for (JobOffer offre : jobOffers) {
//            System.out.println(offre);
//        }

//        System.out.print("Entrez l'ID de l'offre d'emploi à mettre à jour : ");
//        Long updateId = scanner.nextLong();
//        scanner.nextLine(); // Consomme le saut de ligne
//        JobOffer jobOffreToUpdate = jobOffreService.getJobOfferById(updateId);
//
//        if (jobOffreToUpdate != null) {
//            System.out.print("Nouveau titre (laisser vide pour conserver l'ancien) : ");
//            String newTitle = scanner.nextLine();
//            if (!newTitle.isEmpty()) {
//                jobOffreToUpdate.setTitle(newTitle);
//            }
//            System.out.print("Nouvelle description (laisser vide pour conserver l'ancienne) : ");
//            String newDescription = scanner.nextLine();
//            if (!newDescription.isEmpty()) {
//                jobOffreToUpdate.setDescription(newDescription);
//            }
//            // Mettre à jour d'autres champs si nécessaire
//            jobOffreService.updateJobOffer(jobOffreToUpdate); // Mettre à jour l'offre d'emploi
//            System.out.println("Offre d'emploi mise à jour avec succès!");
//        } else {
//            System.out.println("Aucune offre d'emploi trouvée avec cet ID.");
//        }
//
//        // Suppression d'une offre d'emploi
//        System.out.print("Entrez l'ID de l'offre d'emploi à supprimer : ");
//        Long deleteId = scanner.nextLong();
//        jobOffreService.deleteJobOffer(deleteId);
//        System.out.println("Offre d'emploi supprimée avec succès!");
//
//        scanner.close();


    }}
