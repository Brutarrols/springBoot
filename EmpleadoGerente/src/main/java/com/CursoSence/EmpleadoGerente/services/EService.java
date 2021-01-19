package com.CursoSence.EmpleadoGerente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.EmpleadoGerente.models.Employee;
import com.CursoSence.EmpleadoGerente.repositories.EmployeeRepository;

@Service
public class EService {

	private final EmployeeRepository repository;
	
	public EService(EmployeeRepository repository)
	{
		this.repository = repository;
	}
	
	public Employee createEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	

	public Employee findEmployee(Long id)
	{
		Optional<Employee> e = repository.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		else
		{
			return null;
		}
		 
	}
	
	public List<Employee> findManager(Long id)
	{
		return repository.findByManager(id);	  
	}
}
