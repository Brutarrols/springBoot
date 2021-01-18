package com.CursoSence.DojoOverflow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CursoSence.DojoOverflow.models.Answer;
import com.CursoSence.DojoOverflow.models.Question;
import com.CursoSence.DojoOverflow.models.Tag;
import com.CursoSence.DojoOverflow.repositories.AnswerRepository;
import com.CursoSence.DojoOverflow.repositories.QuestionRepository;
import com.CursoSence.DojoOverflow.repositories.TagReository;

@Service
public class DOService {
	
	private final AnswerRepository repositoryA;
	private final QuestionRepository repositoryQ;
	private final TagReository repositoryT;
	
	public DOService(AnswerRepository repositoryA, QuestionRepository repositoryQ, TagReository repositoryT)
	{
		this.repositoryA = repositoryA;
		this.repositoryQ = repositoryQ;
		this.repositoryT = repositoryT;
	}
	
	public Question createQuestion(Question question)
	{
		return repositoryQ.save(question);
	}
	public Answer createAnswer(Answer answer)
	{
		return repositoryA.save(answer);
	}
	public Tag createTag(Tag tag)
	{
		return repositoryT.save(tag);
	}
	
	public List<Question> allQuestions()
	{
		return (List<Question>) repositoryQ.findAll();
	}
	
	public Question findQuestion(Long id)
	{
		Optional<Question> q = repositoryQ.findById(id); 
		if(q.isPresent())
		{
			return q.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Tag> allTags()
	{
		return (List<Tag>) repositoryT.findAll();
	}
}
