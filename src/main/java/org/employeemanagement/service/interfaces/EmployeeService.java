package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Long id);
}
