package com.CursoSence.EmpleadoGerente.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	//private Integer manager_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	@OneToMany(mappedBy="manager",fetch=FetchType.LAZY)
	private List<Employee> employees;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Employee()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/*public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}*/

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
	
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}
	
}
