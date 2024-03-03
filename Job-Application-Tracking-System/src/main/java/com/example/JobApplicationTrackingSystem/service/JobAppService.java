package com.example.JobApplicationTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobApplicationTrackingSystem.model.JobApplicationTS;
import com.example.JobApplicationTrackingSystem.repo.JobAppRepo;

@Service
public class JobAppService {
    
    @Autowired
    JobAppRepo repo;
    
    public List<JobApplicationTS> getAllJobApplications() {
        List<JobApplicationTS> jobAppList = new ArrayList<>();
        repo.findAll().forEach(jobAppList::add);
        return jobAppList;
    }
    
    public JobApplicationTS getJobApplicationTSById(Long id) {
        return repo.findById(id).orElse(null);
    }
    
    public boolean updateStatus(Long id) {
        JobApplicationTS jobApp = getJobApplicationTSById(id);
        if (jobApp != null) {
            jobApp.setStatus("Hired");
            repo.save(jobApp);
            return true;
        }
        return false;
    }
    
    public boolean saveOrUpdateJobApp(JobApplicationTS jobApp) {
        JobApplicationTS updatedObj = repo.save(jobApp);
        return updatedObj != null;
    }
    
    public boolean deleteJobApp(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

 


}
