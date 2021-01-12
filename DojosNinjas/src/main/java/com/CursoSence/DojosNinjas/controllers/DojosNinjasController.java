package com.CursoSence.DojosNinjas.controllers;

import javax.validation.Valid;

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

@Controller
public class DojosNinjasController {
	
	private final DojoNinjasService servicio;
	
	public DojosNinjasController(DojoNinjasService servicio)
	{
		this.servicio = servicio;
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
	
}
