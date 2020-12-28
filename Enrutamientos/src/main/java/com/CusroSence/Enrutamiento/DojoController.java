package com.CusroSence.Enrutamiento;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{pagina}")
	public String index(@PathVariable(value="pagina", required=false) String pagina )
	{
		if(pagina.equals("san-jose"))
		{
			return "El Dojo SJ es el cuartel general";
		}
		if(pagina.equals("burbank-dojo"))
		{
			return  "El Dojo Burbank está localizado al sur de California";
		}
		else
		{
			return "¡El Dojo es increíble!";
		}
	}
	
}
