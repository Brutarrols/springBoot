package com.CursoSence.DojoOverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String subject;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="questions_tags",
			joinColumns = @JoinColumn(name="question_id"),
			inverseJoinColumns = @JoinColumn(name="tag_id")
			)
	private List<Question> questions;
	
	public Tag()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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
