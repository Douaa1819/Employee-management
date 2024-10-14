package org.employeemanagement.repository.interfaces;



import org.employeemanagement.model.Application;

import java.util.List;

public interface ApplicationRepository {
    Application save(Application application);
    Application findById(Long id);
    List<Application> findAll();
    public List<String> findAllSkills();
    List<Application> findDistinctByCompetencies(String competency);
}
