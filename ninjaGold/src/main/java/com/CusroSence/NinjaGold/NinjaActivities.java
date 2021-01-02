package com.CusroSence.NinjaGold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class NinjaActivities {

	private int oro;
	ArrayList<String> historial = new ArrayList<String>();	
	
	public NinjaActivities()
	{
		
	}
	
	public void setOro(int oro)
	{
		this.oro = oro;
	}	
	public int getOro()
	{
		return this.oro;
	}
	public ArrayList<String> getHistorial()
	{
		return this.historial;
	}
	
	public int Azar(int desde, int hasta, boolean resta)
	{
		Random rng = new Random();
		Date fecha =  new Date();
		
		int resultado = desde + rng.nextInt(hasta-desde);
		String accion = ""; 
		
		if(resta)
		{
			this.oro -= resultado;
			accion = "has perdido "+ resultado + " de oro. ("+ fecha+").";
			if(this.oro < 0 )
			{
				this.oro = 0;
			}
		}
		else
		{
			accion = "has ganado "+ resultado + " de oro. ("+ fecha+").";
			this.oro += resultado;
		}
		this.historial.add(accion);
		
		return resultado;
	}
	
}
