package org.employeemanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
    @Table(name = "recruiter")
    public class Recruiter extends User {

        @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
        private List<JobOffer> jobOffers = new ArrayList<>();

        public Recruiter() {
        }

    public Recruiter(String name, String email, String password, Date birthDate) {
        super(name, email,password,birthDate);
    }


    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }
}
