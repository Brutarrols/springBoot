package com.CursoSence.repasoEventos.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	
	@Email(message="E-mail must be valid")
	private String email;
	private String location;
	@Size(max=2)
	private String State;
	@Size(min=5, message="Password must be grater than 5 characters")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(updatable = false)
	private Date CreatedAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Mensage> mensages;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> her_events;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="event_id")
			)
	private List<Event> events;
	
	public User()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	public List<Mensage> getMensages() {
		return mensages;
	}

	public void setMensages(List<Mensage> mensages) {
		this.mensages = mensages;
	}

	
	public List<Event> getHer_events() {
		return her_events;
	}

	public void setHer_events(List<Event> her_events) {
		this.her_events = her_events;
	}

	@PrePersist
	protected void onCreate()
	{
		this.CreatedAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt =  new Date();
	}
}
