package org.employeemanagement.model;

import java.util.Date;

public class Recruiter extends User{

    public Recruiter() {
    }

    public Recruiter(String name, String email, String password, Date birthDate) {
        super(name, email,password,birthDate);
    }
}
