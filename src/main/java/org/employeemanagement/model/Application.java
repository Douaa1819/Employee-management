package org.employeemanagement.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Application extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;
    private String skills;

    @OneToMany(mappedBy = "application")
    private List<ApplicationJobOffer> jobOffers = new ArrayList<>();

    public List<ApplicationJobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<ApplicationJobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }
    public Application( ) {

    }

    public Application(String name, String email, String password, Date birthDate, String document, String skills) {
        super(name, email, password, birthDate);
        this.document = document;
        this.skills = skills;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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


}
