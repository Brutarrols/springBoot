package com.CusroSence.HolaHumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping("")
	public String index(@RequestParam(value="name", required =false)String nombre)
	{
		if(nombre == null)
		{
			return "Hola Humano";
		}
		else
		{
			return "Hola "+ nombre;
		}
	}
}
