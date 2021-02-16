package com.CursoSence.WaterBnB.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CursoSence.WaterBnB.models.Pool;
import com.CursoSence.WaterBnB.models.Review;
import com.CursoSence.WaterBnB.models.User;
import com.CursoSence.WaterBnB.services.WService;

@Controller
public class WController {

	private final WService service;

	public WController(WService service)
	{
		this.service = service;
	}

	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/signin")
	public String signin(@ModelAttribute("user") User user)
	{
		return "signin.jsp";
	}
	
	@PostMapping("/registration")
	public String signin(@ModelAttribute("user")User user, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "login.jsp";
		}
		else
		{
			if(user.getRole().equals("HOST"))
			{
				service.registrerHost(user);
			}
			else
			{
				service.registrerHost(user);
			}
			return "redirect:/host/dashboard";
		}
	}

	@RequestMapping("/host/dashboard")
	public String dashboard(@ModelAttribute("pool")Pool pool, Model model, HttpSession session)
	{
		model.addAttribute("pools", service.userById((Long) session.getAttribute("user_id")).getPools());
		return "dashboard.jsp";
	}
	
	@PostMapping("/host/createPool")
	public String pool(@ModelAttribute("pool")Pool pool, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "dashboard.jsp";
		}
		else
		{
			pool.setUser(service.userById((Long) session.getAttribute("user_id")));
			service.createPool(pool);
			return "redirect:/host/dashboard";
		}
	}
	@GetMapping("/search")
	public String search(@RequestParam("location")String location, Model model)
	{
		model.addAttribute("search", service.findUserByAddress(location));
		return "search.jsp";
	}
	
	@RequestMapping("/pools/{id}")
	public String viewPool(@PathVariable("id")Long id, Model model, HttpSession session)
	{
		model.addAttribute("pool", service.findPool(id));
		return "poolView.jsp";
	}

	@RequestMapping("/pools/{id}/review")
	public String poolReview(@PathVariable("id")Long id, @ModelAttribute("review")Review review, HttpSession session)
	{
		return "review.jsp";
	}
	
	@PostMapping("/pools/{id}/review")
	public String createReview(@ModelAttribute("review")Review review, @PathVariable("id") Long id, BindingResult result, HttpSession session)
	{
		if(result.hasErrors())
		{
			return "review.jsp";
		}
		else
		{
			review.setPool(service.findPool(id));
			review.setUser(service.userById((Long) session.getAttribute("user_id")));
			service.createReview(review);
			return "redirect:/pools/"+id+"/review";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
}
