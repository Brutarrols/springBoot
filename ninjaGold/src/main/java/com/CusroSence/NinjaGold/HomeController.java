package com.CusroSence.NinjaGold;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String actividad(@RequestParam(value="actividad") String actividad, HttpSession sesion, Model model)
	{
		
		NinjaActivities ninja = (NinjaActivities) sesion.getAttribute("ninja");
		int opcion = Integer.parseInt(actividad);
		
		switch(opcion)
		{
			case 1 : ninja.Azar(10, 20, false);break;
			case 2 : ninja.Azar(5, 10, false);break;
			case 3 : ninja.Azar(2, 4, false);break;
			case 4 : ninja.Azar(0, 50, ganaPierde());break;
		}
		
		sesion.setAttribute("ninja", ninja);
		model.addAttribute("ninja", ninja);
		
		return "redirect:/";
		
	}
	@RequestMapping("/")
	public String index(HttpSession sesion, Model model)
	{
		NinjaActivities ninja;
		if(sesion.getAttribute("ninja") == null)
		{
			ninja = new NinjaActivities(); 
		}
		else
		{
			ninja = (NinjaActivities) sesion.getAttribute("ninja");
		}
		
		model.addAttribute("ninja", ninja);
		sesion.setAttribute("ninja", ninja);
		
		return "index.jsp";
	}
	
	private boolean ganaPierde()
	{
		Random rng = new Random();
		int probabilidad = rng.nextInt(100);
		
		if(probabilidad < 50)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
