package com.CursoSence.WaterBnB.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.WaterBnB.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}
