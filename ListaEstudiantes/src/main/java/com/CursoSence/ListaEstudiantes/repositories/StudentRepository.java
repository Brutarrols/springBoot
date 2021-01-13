package com.CursoSence.ListaEstudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ListaEstudiantes.models.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long>{

}
