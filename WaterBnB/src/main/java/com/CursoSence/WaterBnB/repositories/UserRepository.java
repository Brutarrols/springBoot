package com.CursoSence.WaterBnB.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.WaterBnB.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findUserByEmail(String email);
}
