package com.CusroSence.EncuestaDojo;

public class PlanillaEncuesta {

	private String nombre;
	private String dojo;
	private String lenguaje;
	private String comentario;
	
	public PlanillaEncuesta(String nombre, String dojo,String lenguaje, String comentario)
	{
		this.nombre = nombre;
		this.dojo = dojo;
		this.lenguaje = lenguaje;
		this.comentario = comentario;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	public String getDojo()
	{
		return this.dojo;
	}
	public String getLenguaje()
	{
		return this.lenguaje;
	}
	public String getComentario()
	{
		return this.comentario;
	}
}
