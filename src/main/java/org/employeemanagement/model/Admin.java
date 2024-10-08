package org.employeemanagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {



    public Admin() {
        super();
    }

    public Admin(String name, String email, String password ,Date birthDate) {
        super(name, email,password,birthDate);
    }

}
