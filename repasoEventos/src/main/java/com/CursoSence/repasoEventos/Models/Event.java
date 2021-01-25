package com.CursoSence.repasoEventos.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String location;
	@Size(max=2)
	private String state;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@OneToMany(mappedBy="event",fetch=FetchType.LAZY)
	private List<Mensage> mensages;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns= @JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	private List<User> users;
	
	public Event()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public List<Mensage> getMensages() {
		return mensages;
	}

	public void setMensages(List<Mensage> mensages) {
		this.mensages = mensages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	protected void onCreated()
	{
		this.createdAt = new Date();
	}
	
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}

}
