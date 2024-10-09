package org.employeemanagement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Application extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;
    private String skills;
    private boolean status;

    public Application( ) {

    }

    public Application(String name, String email, String password, Date birthDate, String document, String skills, boolean status) {
        super(name, email, password, birthDate);
        this.document = document;
        this.skills = skills;
        this.status = status;
    }



    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
