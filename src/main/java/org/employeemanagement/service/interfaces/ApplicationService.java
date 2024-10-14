package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.Application;

import java.util.List;

public interface ApplicationService {
    Application save(Application application);
    Application findById(Long id);
    List<Application> findAll();
    public List<String> findAllSkills();
    List<Application> findDistinctByCompetencies(String competency);
}
