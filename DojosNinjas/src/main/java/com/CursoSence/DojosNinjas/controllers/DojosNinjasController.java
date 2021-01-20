package com.CursoSence.DojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CursoSence.DojosNinjas.models.Dojo;
import com.CursoSence.DojosNinjas.models.Ninja;
import com.CursoSence.DojosNinjas.services.DojoNinjasService;
import com.CursoSence.DojosNinjas.services.NinjaService;

@Controller
public class DojosNinjasController {
	
	private final DojoNinjasService servicio;
	private final NinjaService ninjaService;
	
	public DojosNinjasController(DojoNinjasService servicio, NinjaService ninjaService)
	{
		this.servicio = servicio;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo)
	{
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String saveDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result )
	{
		if(result.hasErrors())
		{
			return "newDojo.jsp";
		}
		else
		{
			servicio.createDojo(dojo);
			return "redirect:/dojos/new ";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String saveNinja(@ModelAttribute("ninja")Ninja ninja, Model model)
	{
		model.addAttribute("dojos", servicio.allDojos());
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String sabeNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newNinja.jsp";
		}
		else
		{
			servicio.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id")Long id, Model model)
	{
		model.addAttribute("dojo", servicio.findDojo(id));
		
		return "view.jsp";
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    //Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última página) 
	    Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	    //Total número de páginas que tenemos
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}

	
}
