package com.CusroSence.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession sesion)
	{
		int contador;
		if(sesion.getAttribute("contador") == null)
		{
			contador = 0;
		}
		else
		{
			contador = (int) sesion.getAttribute("contador");
		}
		
		contador++;
		sesion.setAttribute("contador", contador);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession sesion, Model model)
	{
		int contador = (int) sesion.getAttribute("contador");
		model.addAttribute("contador", contador);
		
		return "contador.jsp";
	}
}
