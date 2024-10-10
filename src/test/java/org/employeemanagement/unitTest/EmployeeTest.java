package org.employeemanagement.unitTest;

import jakarta.transaction.Transactional;
import org.employeemanagement.exception.IdNotFoundException;
import org.employeemanagement.model.Employee;
import org.employeemanagement.repository.interfaces.EmployeeRepository;
import org.employeemanagement.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class EmployeeTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Employee employee = new Employee();
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Dou");
        employee.setEmail("douaa.doe@example.com");
        employee.setPassword("securePassword");
        employee.setBirthDate(new Date());
        employee.setDepartment("HR");
        employee.setPosition("Manager");
        employee.setAddress("123 Main St");
        employee.setPhoneNumber("1234567890");
        employee.setSalary(50000.00);
        employee.setSoldConge("10");
        employee.setSocialSecurityNumber("123-45-6789");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee createdEmployee = employeeService.addEmployee(employee);

        assertEquals(employee.getId(), createdEmployee.getId());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }


    @Test
    public void testUpdateEmployee() {

        Employee existingEmployee = new Employee();
        existingEmployee.setId(1L);
        existingEmployee.setName("Dou");
        existingEmployee.setEmail("douaa.doe@example.com");
        existingEmployee.setPassword("securePassword");
        existingEmployee.setBirthDate(new Date());
        existingEmployee.setDepartment("HR");
        existingEmployee.setPosition("Manager");
        existingEmployee.setAddress("123 Main St");
        existingEmployee.setPhoneNumber("1234567890");
        existingEmployee.setSalary(50000.00);
        existingEmployee.setSoldConge("10");
        existingEmployee.setSocialSecurityNumber("123-45-6789");

        // Create an updated employee object
        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(1L);
        updatedEmployee.setName("Updated Name");
        updatedEmployee.setEmail("updated.douaa.doe@example.com");
        updatedEmployee.setPassword("newSecurePassword");
        updatedEmployee.setBirthDate(new Date());
        updatedEmployee.setDepartment("Finance");
        updatedEmployee.setPosition("Senior Manager");
        updatedEmployee.setAddress("456 Another St");
        updatedEmployee.setPhoneNumber("0987654321");
        updatedEmployee.setSalary(60000.00);
        updatedEmployee.setSoldConge("15");
        updatedEmployee.setSocialSecurityNumber("987-65-4321");


        when(employeeRepository.update(any(Employee.class))).thenReturn(updatedEmployee);

        // Act
        Employee result = employeeService.updateEmployee(updatedEmployee);

        // Assert
        assertEquals(updatedEmployee.getName(), result.getName());
        assertEquals(updatedEmployee.getEmail(), result.getEmail());
        assertEquals(updatedEmployee.getPosition(), result.getPosition());
        verify(employeeRepository, times(1)).update(any(Employee.class));
    }
    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        when(employeeRepository.findById(1L)).thenReturn(employee);

        Employee foundEmployee = employeeService.getEmployeeById(1L);

        assertEquals(employee.getId(), foundEmployee.getId());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> foundEmployees = employeeService.getAllEmployees();

        assertEquals(employees.size(), foundEmployees.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        doNothing().when(employeeRepository).delete(1L);
        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).delete(1L);
    }
}