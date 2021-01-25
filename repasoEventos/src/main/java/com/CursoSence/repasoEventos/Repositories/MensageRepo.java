package com.CursoSence.repasoEventos.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.repasoEventos.Models.Mensage;

@Repository
public interface MensageRepo extends CrudRepository<Mensage,Long>{

}
