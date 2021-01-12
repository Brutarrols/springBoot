package com.CursoSence.Relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CursoSence.Relationships.models.License;
import com.CursoSence.Relationships.models.Person;
import com.CursoSence.Relationships.services.RelationshipService;

@Controller
public class RelationshipController {
	
	private final RelationshipService servicio;
	
	public RelationshipController(RelationshipService servicio)
	{
		this.servicio = servicio;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person)
	{
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String savePerson(@Valid @ModelAttribute("person")Person person, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newPerson.jsp";
		}
		else
		{
			servicio.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")License license, Model model)
	{
		List<Person> lista = servicio.findAll();
		
		model.addAttribute("listPerson",lista);
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String saveLicense(@Valid @ModelAttribute("license")License license, BindingResult result)
	{		
		license.setNumber(Long.toString(license.getPerson().getId()));		
		if(result.hasErrors())
		{
			return "newLicense.jsp";
		}
		else
		{
			
			servicio.createLicence(license);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String view(@PathVariable("id")Long id, Model model)
	{
		License p = servicio.viewLicence(id);
		
		model.addAttribute("persona",p);
		
		return "view.jsp";
	}
}
