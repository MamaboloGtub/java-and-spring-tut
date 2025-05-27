package com.mamabologtub.employeemvc.services;

import java.util.List;
import java.util.UUID;

import com.mamabologtub.employeemvc.models.JobPosting;

/**
 * @Author Tshepo M Mahudu on Apr 13, 2025.
 */

public interface JobPostingService {

    JobPosting getJobPosting(UUID id);
    List<JobPosting> listJobPostings();

}
