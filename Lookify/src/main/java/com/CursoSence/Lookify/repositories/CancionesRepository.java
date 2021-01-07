package com.CursoSence.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.Lookify.models.Song;

@Repository
public interface CancionesRepository extends CrudRepository<Song,Long> {
	
	List<Song> findByArtista(String artista);
	
	List<Song> findAllOrderByClasificacionDesc();
}
