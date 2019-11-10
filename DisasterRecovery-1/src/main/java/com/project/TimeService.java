package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TimeService {
	
		
	    @Autowired TimeDAO repository;
	    
	    public void add(Timesheet timesheet) {
	        repository.save(timesheet);
	    }
	    public void delete(int id) {
	        repository.deleteById(id);
	    }
	    public List<Timesheet> getTimesheets() {
	        return (List<Timesheet>) repository.findAll();
	    }
	    public Timesheet getTimesheetById(int id) {
	    	return (Timesheet) repository.findById(id).orElse(new Timesheet());
	    }
	    
	    
}

