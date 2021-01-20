package com.CursoSence.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.DojosNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends PagingAndSortingRepository<Ninja,Long>{
	
}
