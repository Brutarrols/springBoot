package com.CursoSence.DojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojosNinjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long> {

}
