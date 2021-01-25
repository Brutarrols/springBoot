package com.CursoSence.repasoEventos.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CursoSence.repasoEventos.Models.Event;
import com.CursoSence.repasoEventos.Models.Mensage;
import com.CursoSence.repasoEventos.Models.User;
import com.CursoSence.repasoEventos.Repositories.EventRepository;
import com.CursoSence.repasoEventos.Repositories.MensageRepo;
import com.CursoSence.repasoEventos.Repositories.UserRepository;

@Service
public class REService {
	
	private final EventRepository eventRepo;
	private final UserRepository userRepo;
	private final MensageRepo mensageRepo;
	
	public REService(EventRepository eventRepo, UserRepository userRepo, MensageRepo mensageRepo)
	{
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
		this.mensageRepo = mensageRepo;
	}
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public User createUser(User user)
	{
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	    user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public Mensage createMensage(Mensage mensage)
	{
		return mensageRepo.save(mensage);
	}
	public User findUserByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
	
	public User findUserById(Long id)
	{
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent())
		{
			return u.get();
		}
		else 
		{
			return null;
		}
	}
	public Event findEvent(Long id)
	{
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Event> allEvents()
	{
		return (List<Event>) eventRepo.findAll();
	}
	
	public List<Event> eventByState(String state)
	{
		return eventRepo.findByState(state);
	}
	
	public List<Event> eventNoState(String state)
	{
		return eventRepo.findByStateNot(state);
	}
	
	public void deleteEvent(Long id)
	{
		eventRepo.deleteById(id);
	}
}
