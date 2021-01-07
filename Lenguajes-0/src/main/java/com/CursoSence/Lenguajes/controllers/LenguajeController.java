package com.CursoSence.Lenguajes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CursoSence.Lenguajes.models.Lenguaje;
import com.CursoSence.Lenguajes.services.LenguajeService;

@Controller
public class LenguajeController {
	
private final LenguajeService servicio;
	
	public LenguajeController(LenguajeService servicio)
	{
		this.servicio = servicio;
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("lenguaje")Lenguaje len, Model model)
	{
		List<Lenguaje> lenguajes = servicio.todoLenguajes();
		
		model.addAttribute("lenguajes",lenguajes);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String newlenguaje(@Valid @ModelAttribute("lenguaje") Lenguaje len,  BindingResult result)
	{
		if(result.hasErrors())
		{
			return "index.jsp";
		}
		else
		{
			servicio.crearLenguaje(len);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showLenguaje(@PathVariable("id")Long id, Model model)
	{
		Lenguaje len = servicio.buscarLenguaje(id);
		
		model.addAttribute("lenguaje",len);
		
		return "show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String editLenguaje(@PathVariable("id")Long id, Model model)
	{
		Lenguaje len = servicio.buscarLenguaje(id);
		
		model.addAttribute("lenguaje",len);
		
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("lenguaje")Lenguaje len, BindingResult result)
	{
		 if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            servicio.actualizarLenguaje(len);
	            return "redirect:/languages";
	        }
	}
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        servicio.borrarLenguaje(id);
	        return "redirect:/languages";
	    }
}
