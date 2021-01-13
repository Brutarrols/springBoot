package com.CursoSence.ProductosCategorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ProductosCategorias.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product,Long>{

}
