package com.CusroSence.EncuestaDojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="nombre") String nombre, @RequestParam(value="dojo")String dojo, @RequestParam(value="lenguaje") String lenguaje, @RequestParam(value="comentario") String comentario, Model model)
	{
		PlanillaEncuesta nuevo = new PlanillaEncuesta(nombre,dojo,lenguaje,comentario);
		model.addAttribute("resultado", nuevo);
		return "resultado.jsp";
	}
}
