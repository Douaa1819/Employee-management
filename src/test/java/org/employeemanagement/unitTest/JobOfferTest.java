package org.employeemanagement.unitTest;

import jakarta.transaction.Transactional;
import org.employeemanagement.exception.DatabaseOperationException;
import org.employeemanagement.model.JobOffer;
import org.employeemanagement.repository.interfaces.JobOffreRepository;
import org.employeemanagement.service.JobOffreServiceImpl;
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

public class JobOfferTest {

    @Mock
    private JobOffreRepository jobOfferRepository;

    @InjectMocks
    private JobOffreServiceImpl jobOffreService;

    private JobOffer jobOffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jobOffer = new JobOffer("Software Engineer", "Develop software applications", new Date(), true);
    }

    @Test
    public void testAddJobOffer() {
        when(jobOfferRepository.save(any(JobOffer.class))).thenReturn(jobOffer);

        JobOffer createdJobOffer = jobOffreService.addJobOffer(jobOffer);

        assertEquals(jobOffer.getTitle(), createdJobOffer.getTitle());
        verify(jobOfferRepository, times(1)).save(any(JobOffer.class));
    }

    @Test
    public void testGetJobOfferById() {
        when(jobOfferRepository.findById(1L)).thenReturn(jobOffer);

        JobOffer foundJobOffer = jobOffreService.getJobOfferById(1L);

        assertEquals(jobOffer.getId(), foundJobOffer.getId());
        verify(jobOfferRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllJobOffers() {
        List<JobOffer> jobOffers = new ArrayList<>();
        jobOffers.add(jobOffer);
        when(jobOfferRepository.findAll()).thenReturn(jobOffers);

        List<JobOffer> foundJobOffers = jobOffreService.getAllJobOffers();

        assertEquals(jobOffers.size(), foundJobOffers.size());
        verify(jobOfferRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateJobOffer() {
        // Set up the existing job offer
        JobOffer existingJobOffer = new JobOffer();
        existingJobOffer.setId(1L);
        existingJobOffer.setStatus(true);
        existingJobOffer.setTitle("Software Engineer");
        existingJobOffer.setDescription("Develop software applications");

        // Stub the repository to return the existing job offer when findById is called
        when(jobOfferRepository.findById(1L)).thenReturn(existingJobOffer);

        // Update the job offer
        JobOffer updatedOffer = new JobOffer();
        updatedOffer.setId(1L);
        updatedOffer.setTitle("Software");

        // Call the update method
        jobOffreService.updateJobOffer(updatedOffer);

        // Retrieve the updated offer to check the changes
        JobOffer retrievedOffer = jobOffreService.getJobOfferById(1L);
        assertEquals(updatedOffer.getTitle(), retrievedOffer.getTitle());
    }

    @Test
    public void testDeleteJobOffer() {
        doNothing().when(jobOfferRepository).delete(1L);
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(1L);
        when(jobOfferRepository.findById(1L)).thenReturn(jobOffer);

        doNothing().when(jobOfferRepository).delete(1L);

        // Act
        jobOffreService.deleteJobOffer(1L);

        // Assert
        verify(jobOfferRepository, times(1)).delete(1L);
    }
}