package org.employeemanagement.service.interfaces;

import org.employeemanagement.model.Application;

public interface ApplicationService {
    Application save(Application application);
    Application findById(Long id);
}
