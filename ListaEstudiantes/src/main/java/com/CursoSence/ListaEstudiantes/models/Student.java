package com.CursoSence.ListaEstudiantes.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne(mappedBy="student", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private Contact contact;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dormitory_id")
	private Dormitory dormitory;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "classes_students",
			joinColumns = @JoinColumn(name="class_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private List<Class> classes;
	
	public Student()
	{
		
	}
	
	
	public Student(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	

	public Dormitory getDormitory() {
		return dormitory;
	}


	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}
	
	

	public List<Class> getClasses() {
		return classes;
	}


	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}


	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}
}
