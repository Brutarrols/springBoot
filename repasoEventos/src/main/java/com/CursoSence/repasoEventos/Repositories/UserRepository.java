package com.CursoSence.repasoEventos.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.repasoEventos.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
}
