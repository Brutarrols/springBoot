package com.CursoSence.Lenguajes.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.Lenguajes.models.Lenguaje;

@Repository
public interface LenguajeRepository extends CrudRepository<Lenguaje, Long>{
	
}
