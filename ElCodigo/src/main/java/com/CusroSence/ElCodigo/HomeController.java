package com.CusroSence.ElCodigo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String codigo(@RequestParam(value="codigo")String codigo, Model model)
	{
		if(codigo.equals("bushido"))
		{
			return "code.jsp";
		}
		else
		{
			model.addAttribute("mensaje", "Entrena mas duro");
			return "index.jsp";
		}
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
}
