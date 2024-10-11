package org.employeemanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Admin extends User {



    public Admin() {
        super();
    }
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Admin(String name, String email, String password ,Date birthDate) {
        super(name, email,password,birthDate);
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
