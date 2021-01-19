package com.CursoSence.EmpleadoGerente.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CursoSence.EmpleadoGerente.models.Employee;
import com.CursoSence.EmpleadoGerente.services.EService;

@RestController
public class EController {
	
	private final EService service;
	
	public EController(EService service) 
	{
		
		this.service = service;
	}
	
	@RequestMapping("/{id}")
	public Employee viewEmployee(@PathVariable("id")Long id)
 	{
		return service.findEmployee(id);
	}
	
	@RequestMapping("/manager/{id}")
	public List<Employee> viewManager(@PathVariable("id")Long id)
	{
		return service.findManager(id);
	}
}
