package org.employeemanagement.repository.interfaces;

import org.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Employee update(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    void delete(Long id);
}
