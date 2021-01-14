package com.CursoSence.ListaEstudiantes.controllers;

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

import com.CursoSence.ListaEstudiantes.models.Contact;
import com.CursoSence.ListaEstudiantes.models.Dormitory;
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
	
	@RequestMapping("/dorms/new")
	public String newDormitory(@ModelAttribute("dormitory")Dormitory dormitory)
	{
		return "newDorm.jsp";
	}
	@RequestMapping(value="/dorms/new", method=RequestMethod.POST)
	public String newDormitory(@Valid @ModelAttribute("dormitory")Dormitory dormitory, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "newDorm.jsp";
		}
		else
		{
			service.createDormitory(dormitory);
			return "redirect:/dorms/new";
		}
	}
	@RequestMapping(value="/dorms/create", method=RequestMethod.POST)
	public void newDormitory(@RequestParam("name")String name)
	{
		Dormitory d = new Dormitory(name);
		service.createDormitory(d);
	}
	@RequestMapping(value="/dorms/{id}", method=RequestMethod.PUT)
	public String updateDorm(@Valid @ModelAttribute("dormitory")Dormitory dormitory, BindingResult result)
	{
		Student s = dormitory.getStudents().get(0);
		s.setDormitory(dormitory);
		
		List<Student> list = service.findDormitory(dormitory.getId()).getStudents();
		list.add(s);
		dormitory.setStudents(list);
		
		if(result.hasErrors())
		{
			return "newDorm.jsp";
		}
		else
		{
			service.createDormitory(dormitory);
			return "redirect:/dorms/"+dormitory.getId();
		}
	}
	@RequestMapping("/dorms/{id}/add")
	public void addStudent(@PathVariable("id")Long id, @RequestParam("student")Long idStudent)
	{
		Dormitory d = service.findDormitory(id);
		Student s = service.findStudent(idStudent);
		List<Student> list = d.getStudents();
		list.add(s);
		d.setStudents(list);
		service.createDormitory(d);
	}
	@RequestMapping("/dorms/{id}/remove")
	public String removeStudent(@PathVariable("id")Long id, @RequestParam("student")Long idStudent)
	{
		Student s = service.findStudent(idStudent);
		s.setDormitory(null);
		service.createStudent(s);
		return "redirect:/dorms/"+id;
	}
	
	@RequestMapping("/dorms/{id}")
	public String viewDomr(@PathVariable("id")Long id,@ModelAttribute("dormitory")Dormitory dormitory, Model model)
	{
		model.addAttribute("dormitory", service.findDormitory(id));
		model.addAttribute("estudiantes", service.findStudenOutDorms());
		return "viewDorm.jsp";
	}
	
}
