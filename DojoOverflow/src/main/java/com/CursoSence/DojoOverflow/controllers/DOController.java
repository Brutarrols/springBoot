package com.CursoSence.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CursoSence.DojoOverflow.models.Answer;
import com.CursoSence.DojoOverflow.models.Question;
import com.CursoSence.DojoOverflow.models.Tag;
import com.CursoSence.DojoOverflow.service.DOService;

@Controller
public class DOController {

	private final DOService service;
	
	public DOController(DOService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model)
	{
		model.addAttribute("questions", service.allQuestions());
		return "questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	//public String newQuestion(@ModelAttribute("pregunta")Question pregunta)
	public String newQuestion(Model model)
	{
		model.addAttribute("pregunta", new Question());
		return "newQuestion.jsp";
	}

	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String newQuestion(@Valid @ModelAttribute("pregunta")Question question, BindingResult result)
	{
		List<String> list = separarTags(question.getTags().get(0).toString());
		for(Tag tag : service.allTags())
		{
			list.remove(tag.getSubject());
		}
		List<Tag> listT = null;
		for(String tag: list)
		{
			Tag t = new Tag();
			t.setSubject(tag);
			listT.add(t);
		}
		question.setTags(listT);
		
		if(result.hasErrors())
		{
			return "newQuestion.jsp";
		}
		else
		{
			service.createQuestion(question);
			return "redirect:/question/new";
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String newAnswer(@PathVariable("id")Long id, @ModelAttribute("answer")Answer answer,Model model)
	{
		model.addAttribute("question", service.findQuestion(id));
		return "viewQuestion.jsp";
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
	public String newAnswer(@PathVariable("id")Long id, @Valid @ModelAttribute("answer")Answer answer, BindingResult result)
	{
		answer.setQuestion(service.findQuestion(id));
		if(result.hasErrors())
		{
			return "viewQuestion.jsp";
		}
		else
		{
			service.createAnswer(answer);
			return "redirect:/question/"+id;
		}
	}
	
	private ArrayList<String> separarTags(String string)
	{
		String[] tags = string.split(",");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			list.add(StringUtils.capitalize(tags[i]));
		}
		
		return list;
	}
	
	/*@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute("questionTag") QuestionTag questionTag, BindingResult result, @RequestParam("question") String questionWord, @RequestParam("tag") String tagWord) {
    	if (result.hasErrors()) {
    		return "NewQuestion.jsp";
    	}
    	else {
    		Question newQuestion = apiService.createQuestion(questionTag.getQuestions());
    		newQuestion.setQuestion(questionWord);
    		Question question = apiService.updateQuestion(newQuestion);
    		
    		Tag newTag = apiService.createTag(questionTag.getTags());
    		newTag.setSubject(tagWord);
    		Tag tag = apiService.updateTag(newTag);
    		
    		questionTag.setQuestions(question);
    		questionTag.setTags(tag);
    		apiService.createQuestionAndTags(questionTag);
    		return "redirect:/questions";
    	}
    	
    }*/

	
}
