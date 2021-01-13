package com.CursoSence.ListaEstudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.ListaEstudiantes.models.Contact;
import com.CursoSence.ListaEstudiantes.models.Student;
import com.CursoSence.ListaEstudiantes.repositories.ContactRepository;
import com.CursoSence.ListaEstudiantes.repositories.StudentRepository;

@Service
public class LEService {
	
	private final StudentRepository repositoryS;
	private final ContactRepository repositoryC;
	
	public LEService(StudentRepository repositoryS, ContactRepository repositoryC)
	{
		this.repositoryC = repositoryC;
		this.repositoryS = repositoryS;
	}
	
	public Student createStudent(Student student)
	{
		return repositoryS.save(student); 
	}
	public Contact createContact(Contact contact)
	{
		return repositoryC.save(contact);
	}
	
	public Student findStudent(Long id)
	{
		Optional<Student> s = repositoryS.findById(id);
		if(s.isPresent())
		{
			return s.get();
		}
		else
		{
			return null;
		} 
	}
	public List<Student> allStudents()
	{
		return (List<Student>) repositoryS.findAll();
	}

}
