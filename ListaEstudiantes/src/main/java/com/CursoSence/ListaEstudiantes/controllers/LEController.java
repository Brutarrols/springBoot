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
import com.CursoSence.ListaEstudiantes.models.Class;

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
	
	@RequestMapping("/classes/new")
	public String newClass(@ModelAttribute("Clase")Class classe)
	{
		return "newClass.jsp";
	}
	
	@RequestMapping(value="/classes/new", method=RequestMethod.POST)
	public String newClass(@Valid @ModelAttribute("Clase")Class classe, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			return "newClass.jsp";
		}
		else
		{
			service.createClass(classe);
			return "redirecct:/classes/new";
		}
	}
	
	@RequestMapping("/classes/{id}")
	public String viewClass(@ModelAttribute("Clase")Class classe, @PathVariable("id")Long id, Model model)
	{
		model.addAttribute("Clase", service.fingClass(id));
		return "viewClass.jsp";
	}
	
	@RequestMapping(value="/classes/{id}", method=RequestMethod.PUT)
	public String updateClass(@Valid @ModelAttribute("Clase")Class classe, @PathVariable("id")Long id, BindingResult result)
	{
		Student s = classe.getStudents().get(0);
		classe = service.fingClass(id);
		classe.getStudents().add(s);
		
		if(result.hasErrors())
		{
			return "viewClass.jsp";
		}
		else
		{
			service.createClass(classe);
			return "redirect:/classes/{id}";
		}
	}
	
	@RequestMapping("/students/{id}")
	public String viewStudents(@PathVariable("id")Long id, @ModelAttribute("student")Student student,Model model)
	{
		model.addAttribute("student", service.findStudent(id));
		model.addAttribute("classes", service.allClasses());
		
		return "viewStudent.jsp";
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
	public String updateStudents(@PathVariable("id")Long id, @Valid @ModelAttribute("student")Student student, BindingResult result)
	{
		Class c = student.getClasses().get(0);
		Student s = service.findStudent(id);
		List<Class> list = s.getClasses();
		list.add(c);
		s.setClasses(list);
		
		if(result.hasErrors())
		{
			return "viewStudent.jsp";
		}
		else
		{
			service.createStudent(s);
			return "redirect:/students/"+s.getId();
		}
	}
	
	@RequestMapping("/students/{id}/remove")
	public String removeFromStudent(@RequestParam("class")Long idClass, @PathVariable("id")Long id)
	{
		Student s = service.findStudent(id);
		s.getClasses().remove(service.fingClass(idClass));
		service.createStudent(s);
		
		return "redirect:/students/"+id;
	}
}
