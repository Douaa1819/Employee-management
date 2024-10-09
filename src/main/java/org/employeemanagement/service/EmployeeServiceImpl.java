package org.employeemanagement.service;

import org.employeemanagement.model.Employee;
import org.employeemanagement.repository.interfaces.EmployeeRepository;
import org.employeemanagement.service.interfaces.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }
}