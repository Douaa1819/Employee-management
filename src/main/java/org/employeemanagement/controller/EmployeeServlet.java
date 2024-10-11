package org.employeemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.employeemanagement.model.Employee;
import org.employeemanagement.service.interfaces.EmployeeService;
import org.employeemanagement.service.EmployeeServiceImpl;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            listEmployees(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteEmployee(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else {
            listEmployees(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("add")) {
            addEmployee(request, response);
        } else if (action.equals("update")) {
            updateEmployee(request, response);
        } else {
            listEmployees(request, response);
        }
    }




    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("view/list-employees.jsp").forward(request, response);
    }



    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Employee not found");
            return;
        }
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/view/edit-employee.jsp").forward(request, response);
    }



    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-employee.jsp").forward(request, response);
    }




    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Employee employee = extractEmployeeFromRequest(request);
            employeeService.addEmployee(employee);

            request.getSession().setAttribute("successMessage", "L'employé a été ajouté avec succès !");

            response.sendRedirect(request.getContextPath() + "/employee?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Erreur lors de l'ajout de l'employé: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/employee?action=edit");
        }
    }


    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Employee employee = extractEmployeeFromRequest(request);
            employee.setId(Long.parseLong(request.getParameter("id")));
            employeeService.updateEmployee(employee);
            request.getSession().setAttribute("successMessage", "L'employé a été mis a jour avec succès !");
            response.sendRedirect(request.getContextPath() + "/employee?action=list");

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Erreur lors de l'update job offre: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/employee?action=edit");
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            employeeService.deleteEmployee(id);

                response.sendRedirect(request.getContextPath() + "/employee?action=list");
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete employee");
            }
        }

    private Employee extractEmployeeFromRequest(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name is required");
            }

            String email = request.getParameter("email");
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email is required");
            }

            String password = request.getParameter("password");
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Password is required");
            }

            String birthDateString = request.getParameter("birthDate");
            String department = request.getParameter("department");
            String position = request.getParameter("position");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String soldConge = request.getParameter("soldConge");
            String socialSecurityNumber = request.getParameter("socialSecurityNumber");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = dateFormat.parse(birthDateString);

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setPassword(password);
            employee.setBirthDate(birthDate);
            employee.setDepartment(department);
            employee.setPosition(position);
            employee.setAddress(address);
            employee.setPhoneNumber(phoneNumber);
            employee.setSalary(salary);
            employee.setSoldConge(soldConge);
            employee.setSocialSecurityNumber(socialSecurityNumber);

            return employee;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input format for salary");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + e.getMessage());
        }
    }

}
