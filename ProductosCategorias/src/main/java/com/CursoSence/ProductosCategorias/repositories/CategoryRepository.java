package com.CursoSence.ProductosCategorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ProductosCategorias.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

}
