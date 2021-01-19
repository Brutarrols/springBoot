package com.CursoSence.ConsultasJoins.models;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String country_code;
	private String district;
	private Float population;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;
	
	public City()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Float getPopulation() {
		return population;
	}

	public void setPopulation(Float population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
