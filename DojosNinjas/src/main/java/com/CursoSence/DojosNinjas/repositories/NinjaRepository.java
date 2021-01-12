package com.CursoSence.DojosNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojosNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{

}
