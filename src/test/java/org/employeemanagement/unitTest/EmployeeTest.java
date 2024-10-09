package org.employeemanagement.unitTest;

import org.employeemanagement.model.Employee;
import org.employeemanagement.repository.interfaces.EmployeeRepository;
import org.employeemanagement.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class EmployeeTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setId(2L);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee createdEmployee = employeeService.addEmployee(employee);

        assertEquals(employee.getId(), createdEmployee.getId());
        verify(employeeRepository, times(1)).save(any(Employee.class));
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
