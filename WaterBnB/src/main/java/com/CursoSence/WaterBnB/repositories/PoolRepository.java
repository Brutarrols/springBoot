package com.CursoSence.WaterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.WaterBnB.models.Pool;

@Repository
public interface PoolRepository extends CrudRepository<Pool, Long>{
	
	List<Pool> findByAddressContaining(String addres);
}
