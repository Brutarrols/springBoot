package com.CursoSence.DojoOverflow.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String answer;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;
	
	public Answer() 
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt =  new Date();
	}
	
}
