package com.CursoSence.EmpleadoGerente.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.EmpleadoGerente.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	List<Employee> findByManager(Long id);
}
