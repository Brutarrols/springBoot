package com.CursoSence.ConsultasJoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ConsultasJoins.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository <Language,Long>{

}
