package com.CursoSence.ListaEstudiantes.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CursoSence.ListaEstudiantes.models.Contact;
import com.CursoSence.ListaEstudiantes.models.Student;
import com.CursoSence.ListaEstudiantes.services.LEService;

@Controller
public class LEController {

	private final LEService service;
	
	public LEController(LEService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student")Student student)
	{
		return "newStudent.jsp";
	}
	
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
	public String newStudent(@Valid @ModelAttribute("student")Student student, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newStudent.jsp";
		}
		else
		{
			service.createStudent(student);
			return "redirect:/students/new";
		}
	}
	
	@RequestMapping("/students/create")
	public void newStudent(@RequestParam(value="firstName")String Fname, @RequestParam(value="lastName")String Lname, @RequestParam(value="age")Integer age)
	{
		Student s = new Student(Fname, Lname, age);
		service.createStudent(s);
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact")Contact contact, Model model)
	{
		model.addAttribute("students", service.allStudents());
		return "newContact.jsp";
	}
	
	@RequestMapping(value="/contacts/new", method=RequestMethod.POST)
	public String newContact(@Valid @ModelAttribute("contact")Contact contact, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newContact.jsp";
		}
		else
		{
			service.createContact(contact);
			return "redirect:/contacts/new";
		}
	}
	
	@RequestMapping("/contacts/create")
	public void newContact(@RequestParam("student")Long id, @RequestParam("address")String address, @RequestParam("city")String city, @RequestParam("state")String state)
	{
		
		Contact c = new Contact(address, city, state, service.findStudent(id));
		service.createContact(c);
	}
	
	@RequestMapping("/students")
	public String allStudents(Model model)
	{
		model.addAttribute("students", service.allStudents());
		return "viewStudents.jsp";
	}
}
