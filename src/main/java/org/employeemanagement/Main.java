package org.employeemanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.employeemanagement.model.Employee;
import org.employeemanagement.repository.EmployeeRepositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

//    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("employeesmanagment");
//    EntityManager entityManager=entityManagerFactory.createEntityManager();
//    entityManager.getTransaction().begin();
//    entityManager.getTransaction().commit();

    public static void main(String[] args) {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

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


        // 2. Récupérer tous les employés
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


    }}
