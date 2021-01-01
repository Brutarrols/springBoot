package com.CusroSence.MostrarFecha;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/fecha")
	public String fecha(Model model)
	{
		LocalDateTime date = LocalDateTime.now();
		model.addAttribute("fecha", date);
		return "fecha.jsp";
	}
	
	@RequestMapping("/hora")
	public String hora(Model model)
	{
		LocalDateTime date = LocalDateTime.now();
		model.addAttribute("fecha", date);
		return "hora.jsp";
	}
}

