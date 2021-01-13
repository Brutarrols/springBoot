package com.CursoSence.ListaEstudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ListaEstudiantes.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long>{

}
