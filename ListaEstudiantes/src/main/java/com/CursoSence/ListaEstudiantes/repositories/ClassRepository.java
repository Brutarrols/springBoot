package com.CursoSence.ListaEstudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ListaEstudiantes.models.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>{

}
