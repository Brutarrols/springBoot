package com.CursoSence.ConsultasJoins.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CursoSence.ConsultasJoins.repositories.CityRepository;
import com.CursoSence.ConsultasJoins.repositories.CountryRepository;
import com.CursoSence.ConsultasJoins.repositories.LanguageRepository;

@Service
public class CJService {

	private final CityRepository cityR;
	private final CountryRepository countryR;
	private final LanguageRepository languageR;
	
	public CJService(CityRepository cityR, CountryRepository countryR,LanguageRepository languageR)
	{
		this.cityR = cityR;
		this.countryR = countryR;
		this.languageR = languageR;
	}
	
	public List<Object[]> slovene()
	{
		return countryR.selectSlovan();
	}
	
	public List<Object[]> dos()
	{
		return countryR.cantCiudades() ;
	}
	
	public List<Object[]> tres()
	{
		return countryR.consultaTres();
	}
	public List<Object[]> cuatro()
	{
		return countryR.consultaCuatro();
	}
	public List<Object[]> cinco()
	{
		return countryR.consultaCinco();
	}
	public List<Object[]> seis()
	{
		return countryR.consultaseis();
	}
	public List<Object[]> siete()
	{
		return countryR.consultaSiete();
	}
	public List<Object[]> ocho()
	{
		return countryR.consultaOcho();
	}
	
}
