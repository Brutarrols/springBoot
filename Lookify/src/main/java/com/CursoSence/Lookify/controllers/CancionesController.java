package com.CursoSence.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CursoSence.Lookify.models.Song;
import com.CursoSence.Lookify.services.CancionesService;

@Controller
public class CancionesController {

	private final CancionesService servicio;
	
	public CancionesController(CancionesService servicio)
	{
		this.servicio = servicio;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model)
	{
		List<Song> canciones = servicio.todasCanciones();
		
		model.addAttribute("canciones",canciones);
		
		return "dashboard.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model)
	{
		List<Song> canciones = servicio.topTen();
		
		model.addAttribute("canciones",canciones);
		
		return "topTen.jsp";
	}
	
	@RequestMapping("/search")
	public String cancionesArtista(@RequestParam(value="artista")String artista, Model model)
	{
		List<Song> canciones = servicio.buscarArtista(artista);
		
		model.addAttribute("artista", artista);
		model.addAttribute("canciones",canciones);
		
		return "artista.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String cancion(@PathVariable("id") Long id, Model model)
	{
		Song cancion = servicio.buscarCancion(id);
		model.addAttribute("cancion", cancion);
		
		return "showCancion.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String nuevaCancion(@Valid @ModelAttribute("song")Song song)
	{
		return "newSong.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String newCancion(@Valid @ModelAttribute("song") Song song, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newSong.jsp";
		}
		else
		{
			servicio.crearCancion(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String borrarCancion(@PathVariable("id")Long id)
	{
		servicio.borrarCancion(id);
		return "redirect:/dashboard";
	}
}
