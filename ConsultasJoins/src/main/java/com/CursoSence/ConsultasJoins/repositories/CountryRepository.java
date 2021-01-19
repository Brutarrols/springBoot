package com.CursoSence.ConsultasJoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CursoSence.ConsultasJoins.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long>{
	
	@Query(value="select countries.name, languages.language, languages.percentage from countries left join languages on countries.id = languages.country_id where language = 'slovene' order by languages.percentage desc", nativeQuery=true)
	List<Object[]> selectSlovan();
	
	@Query(value="select countries.name as pais, count(cities.name) as  Numero_ciudad from countries inner join cities on countries.id = cities.country_id group by countries.id order by Numero_ciudad desc", nativeQuery=true)
	List<Object[]> cantCiudades();
	
	@Query(value="select name , population from cities where country_id = 136 and cities.population > 500000 order by cities.population desc", nativeQuery=true)
	List<Object[]> consultaTres();
	
	@Query(value="select countries.name, languages.language, languages.percentage from countries, languages where languages.percentage > 89 order by languages.percentage desc", nativeQuery=true)
	List<Object[]> consultaCuatro();
	
	@Query(value="select * from countries where surface_area < 501 and population > 100000", nativeQuery=true)
	List<Object[]> consultaCinco();
	
	@Query(value="select * from countries where government_form = 'Constitutional Monarchy' and capital >200 and life_expectancy > 75", nativeQuery=true)
	List<Object[]> consultaseis();
	
	@Query(value="select countries.name as pais, cities.name, cities.district, cities.population from countries, cities where cities.population > 500000 and countries.id = 9 and district = 'Buenos Aires'", nativeQuery=true)
	List<Object[]> consultaSiete();
	
	@Query(value="select region, count(id) as cantidad_paises from countries group by region order by cantidad_paises desc", nativeQuery=true)
	List<Object[]> consultaOcho();
}
