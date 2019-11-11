package com.project;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobService {
	
	@Autowired
	private JobDAO jd;

	public Job getJobById(int id) {
		return (Job) jd.findById(id).orElse(new Job());
	}
	
	public void saveJob(Job job) {
		jd.save(job);
	}
	
	public void removeJob(int id) {
//		if(jobRepo.existsById(id)) {
			jd.deleteById(id);
//		}else {
//			
//		}
	}
	
	public List<Job> getAllJobs(){
		return (List<Job>) jd.findAll();
	}

	
	
	
	
	
}
