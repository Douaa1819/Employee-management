package org.employeemanagement.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table( name="job-offre")
public class JobOffer {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date postDate;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
    @OneToMany(mappedBy = "jobOffer")
    private List<ApplicationJobOffer> applications = new ArrayList<>();

    public List<ApplicationJobOffer> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationJobOffer> applications) {
        this.applications = applications;
    }
    public JobOffer() {

}
    public JobOffer( String title, String description, Date postDate, boolean status) {

        this.title = title;
        this.description = description;
        this.postDate = postDate;
        this.status = status;
    }


    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
