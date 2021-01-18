package com.CursoSence.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojoOverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

}
