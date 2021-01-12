package com.CursoSence.DojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.DojosNinjas.models.Dojo;
import com.CursoSence.DojosNinjas.models.Ninja;
import com.CursoSence.DojosNinjas.repositories.DojoRepository;
import com.CursoSence.DojosNinjas.repositories.NinjaRepository;

@Service
public class DojoNinjasService {
	private final DojoRepository repositoryD;
	private final NinjaRepository repositoryN;
	
	public DojoNinjasService(DojoRepository repositoryD, NinjaRepository repositoryN )
	{
		this.repositoryD = repositoryD;
		this.repositoryN = repositoryN;
	}
	
	public Ninja createNinja(Ninja ninja)
	{
		return repositoryN.save(ninja);
	}
	
	public Dojo createDojo(Dojo dojo)
	{
		return repositoryD.save(dojo);
	}
	
	public Dojo findDojo(Long id)
	{
		Optional<Dojo> d = repositoryD.findById(id);
		if(d.isPresent())
		{
			return d.get();
		}
		else
		{
			return null;
		}
	}
	public List<Dojo> allDojos()
	{
		List<Dojo> dojos = (List<Dojo>) repositoryD.findAll();
		return dojos;
	}
}
