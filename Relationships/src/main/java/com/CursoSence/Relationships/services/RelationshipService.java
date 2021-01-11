package com.CursoSence.Relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.Relationships.models.License;
import com.CursoSence.Relationships.models.Person;
import com.CursoSence.Relationships.repositories.LicenseRepository;
import com.CursoSence.Relationships.repositories.PersonRepository;

@Service
public class RelationshipService {
	
	private final LicenseRepository repositoryL;
	private final PersonRepository repositoryP;
	
	public RelationshipService(LicenseRepository repositoryL, PersonRepository repositoryP)
	{
		this.repositoryL = repositoryL;
		this.repositoryP = repositoryP;
	}
	
	public List<Person> findAll()
	{
		return (List<Person>) repositoryP.findAll();
	}
	public Person createPerson(Person p)
	{
		return repositoryP.save(p);
	}
	
	public License createLicence(License l)
	{
		return repositoryL.save(l);
	}
	
	public Optional<License> viewLicence(Long id)
	{
		return repositoryL.findById(id);
	}
	
	public Optional<Person> viewPerson(Long id)
	{
		return repositoryP.findById(id);
	}
}
