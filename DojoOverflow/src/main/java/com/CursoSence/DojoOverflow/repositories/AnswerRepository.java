package com.CursoSence.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojoOverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {

}
