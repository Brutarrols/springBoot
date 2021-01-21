package com.CursoSence.Autenthication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CursoSence.Autenthication.models.User;
import com.CursoSence.Autenthication.services.UserService;

@Controller
public class Users {
	private final UserService userService;
 
	public Users(UserService userService) {
		this.userService = userService;
	}
 
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
 
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
		 //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
		 
		 if(result.hasErrors())
		 {
			 return "registrationPage.jsp";
		 }
		 else
		 {
			 userService.registerUser(user);
			 session.setAttribute("user", userService.findByEmail(user.getEmail()).getId());
			 return "redirect:/home";
		 }
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		 //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
		 //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
		 
		 User u = userService.findByEmail(email);
		 
		 if(u != null && BCrypt.checkpw(password,u.getPassword()))
		 {
			 session.setAttribute("user", u.getId());
			 return "redirect:/home";
		 }
		 else
		 {
			 model.addAttribute("error", "Usuario inexistente!");
			 return "loginPage.jsp";
		 }
	 }
	 
	 @RequestMapping("/home")
	 public String home(HttpSession session, Model model) {
	     //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
		 
		 model.addAttribute("user", userService.findUserById((Long) session.getAttribute("user")));
		 return "homePage.jsp";
	 }
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidar la sesión
	     // redireccionar a la página de inicio de sesión.
		 
		 session.invalidate();
		 return "redirect:/login";
	 }
}
