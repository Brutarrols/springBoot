package com.CursoSence.ConsultasJoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ConsultasJoins.models.City;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {

}
