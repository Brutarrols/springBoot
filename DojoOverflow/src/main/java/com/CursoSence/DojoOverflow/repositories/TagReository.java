package com.CursoSence.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojoOverflow.models.Tag;

@Repository
public interface TagReository extends CrudRepository<Tag,Long>{

}
