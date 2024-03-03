package com.example.JobApplicationTrackingSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JobApplicationTrackingSystem.model.JobApplicationTS;

@Repository
public interface JobAppRepo extends JpaRepository<JobApplicationTS, Long>{

	
}
