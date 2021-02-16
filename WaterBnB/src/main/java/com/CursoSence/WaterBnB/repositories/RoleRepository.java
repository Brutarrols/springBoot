package com.CursoSence.WaterBnB.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.WaterBnB.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
	Role findRoleByName(String role);
}
