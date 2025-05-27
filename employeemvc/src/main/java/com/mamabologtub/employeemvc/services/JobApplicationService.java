package com.mamabologtub.employeemvc.services;

import java.util.List;
import java.util.UUID;

import com.mamabologtub.employeemvc.models.JobApplication;

/**
 * @Author Tshepo M Mahudu on Apr 13, 2025.
 */

public interface JobApplicationService {

    JobApplication getJobApplication(UUID id);
    List<JobApplication> listJobApplications();

}
