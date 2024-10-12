package org.employeemanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "application_job_offer")
public class ApplicationJobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;


    public ApplicationJobOffer() {
        this.status = false;
    }

    public ApplicationJobOffer(Application application, JobOffer jobOffer) {
        this.application = application;
        this.jobOffer = jobOffer;
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }
}
