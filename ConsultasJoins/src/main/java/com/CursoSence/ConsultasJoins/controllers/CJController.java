package com.CursoSence.ConsultasJoins.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CursoSence.ConsultasJoins.service.CJService;

@Controller
public class CJController {
	
	private final CJService service;
	
	public CJController(CJService service)
	{
		this.service = service;
	}

	@RequestMapping("/")
	public String view(Model model)
	{
		model.addAttribute("slovene", service.slovene());
		model.addAttribute("dos", service.dos());
		model.addAttribute("tres", service.tres());
		model.addAttribute("cuatro", service.cuatro());
		model.addAttribute("cinco", service.cinco());
		model.addAttribute("seis", service.seis());
		model.addAttribute("siete", service.siete());
		model.addAttribute("ocho", service.ocho());
		return "view.jsp";
	}
}
