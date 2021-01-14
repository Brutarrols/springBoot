package com.CursoSence.ListaEstudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.ListaEstudiantes.models.Contact;
import com.CursoSence.ListaEstudiantes.models.Dormitory;
import com.CursoSence.ListaEstudiantes.models.Student;
import com.CursoSence.ListaEstudiantes.repositories.ContactRepository;
import com.CursoSence.ListaEstudiantes.repositories.DormitoryRepo;
import com.CursoSence.ListaEstudiantes.repositories.StudentRepository;

@Service
public class LEService {
	
	private final StudentRepository repositoryS;
	private final ContactRepository repositoryC;
	private final DormitoryRepo repositoryD;
	
	public LEService(StudentRepository repositoryS, ContactRepository repositoryC, DormitoryRepo repositoryD)
	{
		this.repositoryC = repositoryC;
		this.repositoryS = repositoryS;
		this.repositoryD = repositoryD;
	}
	
	public Student createStudent(Student student)
	{
		return repositoryS.save(student); 
	}
	public Contact createContact(Contact contact)
	{
		return repositoryC.save(contact);
	}
	public Dormitory createDormitory(Dormitory dormitory)
	{
		return repositoryD.save(dormitory);
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
	public Dormitory findDormitory(Long id)
	{
		Optional<Dormitory> d = repositoryD.findById(id);
		if(d.isPresent())
		{
			return d.get();
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
	public List<Student> findStudenOutDorms()
	{
		List<Student> s = repositoryS.findByDormitoryNull();
		
		return s;
	}

}
