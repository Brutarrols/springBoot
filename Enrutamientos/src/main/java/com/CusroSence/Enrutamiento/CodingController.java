package com.CusroSence.Enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

	@RequestMapping("")
	public String index()
	{
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/java")
	public String java()
	{
		return "¡Java/Spring es mejor!";
	}
	
	@RequestMapping("/phyton")
	public String phyton()
	{
		return "¡Python/Django fue increíble!";
	}
	
}
