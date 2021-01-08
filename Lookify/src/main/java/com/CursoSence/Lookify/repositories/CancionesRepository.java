package com.CursoSence.Lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.Lookify.models.Song;

@Repository
public interface CancionesRepository extends CrudRepository<Song,Long> {
	
	List<Song> findByArtista(String artista);
	
	@Query(value="select * from canciones order by clasificacion asc", nativeQuery=true)
	List<Song> findAllOrderByClasificacionDesc();
	
	//List<Song> findClasificacionByOrderByClasificacionDesc();

}
