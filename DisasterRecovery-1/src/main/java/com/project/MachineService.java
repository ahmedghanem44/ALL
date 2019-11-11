package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MachineService {
	
    @Autowired 
    MachineDAO repository;
    
    public void add(Machine machine) {
        repository.save(machine);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<Machine> getMachines() {
        return (List<Machine>) repository.findAll();
    }
    public Machine getMachineById(int id) {
    	return (Machine) repository.findById(id).orElse(new Machine());
    }
    
    
}
