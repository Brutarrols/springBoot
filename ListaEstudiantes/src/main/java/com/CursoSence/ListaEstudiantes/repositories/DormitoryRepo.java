package com.CursoSence.ListaEstudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ListaEstudiantes.models.Dormitory;

@Repository
public interface DormitoryRepo extends CrudRepository<Dormitory,Long>{

}
