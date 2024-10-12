package org.employeemanagement.repository.interfaces;



import org.employeemanagement.model.Application;

import java.util.List;

public interface ApplicationRepository {
    Application save(Application application);
    Application findById(Long id);
}
