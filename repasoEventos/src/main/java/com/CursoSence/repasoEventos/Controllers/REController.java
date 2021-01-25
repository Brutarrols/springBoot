package com.CursoSence.repasoEventos.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CursoSence.repasoEventos.Models.Event;
import com.CursoSence.repasoEventos.Models.Mensage;
import com.CursoSence.repasoEventos.Models.User;
import com.CursoSence.repasoEventos.Services.REService;

@Controller
public class REController {
	
	private final REService service;
	
	public REController(REService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/")
	public String registredLogin(@ModelAttribute("user")User user)
	{
		return "LoginRegistrer.jsp";
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST)
	public String registredLogin(@Valid @ModelAttribute("user")User user, Model model, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "LoginRegistrer.jsp";
		}
		else
		{
			service.createUser(user);
			session.setAttribute("user", service.findUserByEmail(user.getEmail()).getId());
			return "redirect:/events";
		}
	}
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String Login(@RequestParam("email")String email, @RequestParam("password")String password, Model model, HttpSession session)
	{
		User u = service.findUserByEmail(email);
		if(u != null && BCrypt.checkpw(password, u.getPassword()))
		{
			session.setAttribute("user", u.getId());
			return "redirect:/events";
		}
		else
		{
			model.addAttribute("error", "invalid User");
			return "LoginRegistrer.jsp";
		}
	}
	@RequestMapping("/events")
	public String EventsCreated(@ModelAttribute("event")Event event, Model model, HttpSession session)
	{
		model.addAttribute("user", service.findUserById((Long) session.getAttribute("user")));
		model.addAttribute("events_by_state", service.eventByState(service.findUserById((Long) session.getAttribute("user")).getState()));
		model.addAttribute("events_no_state", service.eventNoState(service.findUserById((Long) session.getAttribute("user")).getState()));
		return "EventsCreate.jsp";
	}
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public String newEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "EventsCreate.jsp";
		}
		else
		{
			event.setHost(service.findUserById((Long) session.getAttribute("user")));
			service.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/events/{id}")
	public String viewEvent(@PathVariable("id")Long id, @ModelAttribute("mensage")Mensage mensage, Model model) 
	{
		model.addAttribute("event", service.findEvent(id));
		return "viewEvent.jsp";
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.POST)
	public String viewEvent(@PathVariable("id")Long id, @Valid @ModelAttribute("mensage")Mensage mensage, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "viewEvent.jsp";
		}
		else
		{
			mensage.setEvent(service.findEvent(id));
			mensage.setUser(service.findUserById((Long) session.getAttribute("user")));
			service.createMensage(mensage);
			return "redirect:/events/"+id;
		}
	}
	
	@RequestMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id")Long id, @ModelAttribute("event")Event event, Model model)
	{
		model.addAttribute("event", service.findEvent(id));
		return "editEvent.jsp";
	}
	
	@RequestMapping(value="/events/{id}/edit", method=RequestMethod.PUT)
	public String editEvent(@PathVariable("id")Long id, @ModelAttribute("event")Event event, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "editEvent.jsp";
		}
		else
		{
			event.setId(id);
			event.setHost(service.findUserById((Long) session.getAttribute("user")));
			service.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id")Long id)
	{
		service.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
}
