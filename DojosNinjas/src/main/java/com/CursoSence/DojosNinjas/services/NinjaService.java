package com.CursoSence.DojosNinjas.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CursoSence.DojosNinjas.models.Ninja;
import com.CursoSence.DojosNinjas.repositories.NinjaRepo;

@Service
@Transactional
public class NinjaService {
  @Autowired 
  NinjaRepo ninjaRepo;
  //la variable estática establece el número de ninjas que queremos mostrar por página.
  private static final int PAGE_SIZE = 5;
  public Page<Ninja> ninjasPerPage(int pageNumber) {
      // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por apellido.
      PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.DESC , "dojo");
      Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
      return ninjaRepo.findAll(pageRequest);
  }
}

