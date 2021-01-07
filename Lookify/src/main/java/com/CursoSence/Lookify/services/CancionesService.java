package com.CursoSence.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.Lookify.models.Song;
import com.CursoSence.Lookify.repositories.CancionesRepository;

@Service
public class CancionesService {
	
	private final CancionesRepository repositorio;
	
	public CancionesService(CancionesRepository repositorio)
	{
		this.repositorio = repositorio;
	}
	
	public List<Song> todasCanciones()
	{
		return (List<Song>) repositorio.findAll();
	}
	
	public Song crearCancion(Song cancion)
	{
		return repositorio.save(cancion);
	}
	
	public Song actualizarCancion(Song cancion)
	{
		return repositorio.save(cancion);
	}
	
	public Song buscarCancion(Long id)
	{
		Optional<Song> cancion = repositorio.findById(id);
		
		if(cancion.isPresent())
		{
			return cancion.get();
		}
		else
		{
			return null;
		}
	}
	
	/*public List<Song> topTen()
	{
		List<Song> cancionesTop = repositorio.findAllOrderByClasificacionDesc();
		
		return cancionesTop;
	}*/
	
	public List<Song> buscarArtista(String artista)
	{
		List<Song>cancionesArtista = repositorio.findByArtista(artista);
		
		return cancionesArtista;
	}
	
	public void borrarCancion(Long id)
	{
		repositorio.deleteById(id);
	}
}
