package com.CusroSence.MostrarFecha;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	LocalDateTime date = LocalDateTime.now();
	
	@RequestMapping("/fecha")
	public String fecha(Model model)
	{
		model.addAttribute("fecha", this.date);
		return "fecha.jsp";
	}
	
	@RequestMapping("/hora")
	public String hora(Model model)
	{
		model.addAttribute("fecha", this.date);
		return "hora.jsp";
	}
}

