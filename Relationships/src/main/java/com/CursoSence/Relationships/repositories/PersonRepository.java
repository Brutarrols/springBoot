package com.CursoSence.Relationships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CursoSence.Relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{

}
