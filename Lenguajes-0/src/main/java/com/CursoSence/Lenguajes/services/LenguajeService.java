package com.CursoSence.Lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.Lenguajes.models.Lenguaje;
import com.CursoSence.Lenguajes.repositories.LenguajeRepository;

@Service
public class LenguajeService {
	private final LenguajeRepository repositorio;
	
	public LenguajeService(LenguajeRepository repositorio)
	{
		this.repositorio = repositorio;
	}
	
	public List<Lenguaje> todoLenguajes()
	{
		return (List<Lenguaje>) repositorio.findAll();
	}
	public Lenguaje crearLenguaje(Lenguaje len)
	{
		return repositorio.save(len);
	}
	public Lenguaje actualizarLenguaje(Lenguaje len)
	{
		return repositorio.save(len);
	}
	public Lenguaje buscarLenguaje(Long id)
	{
		Optional<Lenguaje> lenguajes = repositorio.findById(id);
		
		if(lenguajes.isPresent())
		{
			return lenguajes.get();
		}
		else
		{
			return null;
		}
	}
	public void borrarLenguaje(Long id)
	{
		repositorio.deleteById(id);
	}
}
