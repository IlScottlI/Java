package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.services.AnswerService;
import com.codingdojo.mvc.services.QuestionService;
import com.codingdojo.mvc.services.TagService;

@Controller
public class IndexController {
	   private final QuestionService questionService;
	   private final TagService tagService;
	   private final AnswerService answerService;
	   public IndexController(
			   QuestionService questionService,
			   TagService tagService,
			   AnswerService answerService
			   ) {
	        this.questionService = questionService;
	        this.tagService = tagService;
	        this.answerService = answerService;
	    }
    @RequestMapping("/questions")
    public String dashboard(Model model) {
    	List<Question> questions = questionService.allItems();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(Model model) {
        return "new-question.jsp";
    }

    @RequestMapping("/questions/{id}")
    public String index(
    		@PathVariable("id") Long id,
    		@ModelAttribute("answer") Answer answer, 
    		Model model
    		) {
    	List<Answer> answers = questionService.findItem(id).getAnswers();
    	Question question = questionService.findItem(id);
    	model.addAttribute("answers", answers);
    	model.addAttribute("question", question);
    	model.addAttribute("tags", question.getTagsQuestions());
        return "view-question.jsp";
    }
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String addAnswer(
    		@PathVariable("id") Long id,
    		@RequestParam(value="answer") String answer,
    		Model model
    		) {
    	
    	Question question = questionService.findItem(id);
    	
        if (answer.isBlank()) {
        	model.addAttribute("answers", question.getAnswers());
        	model.addAttribute("question", question);
        	model.addAttribute("isError", true);
            return "view-question.jsp";
        } else {
        	Answer newAnswer =  new Answer();
        	newAnswer.setAnswer(answer);
        	newAnswer.setQuestion(question);
        	answerService.createItem(newAnswer);
        	model.addAttribute("isError", false);
            return "redirect:/questions/" + id;   
        }
    }
    @RequestMapping(value = "/questions/new", method = RequestMethod.POST)
    public String newQuestion(
            @RequestParam(value="tags") String tags,
    		@Valid @ModelAttribute("question") Question question, 
    		BindingResult result
    		) {
        if (result.hasErrors()) {
            return "new-question.jsp";
        } else {
            List<Tag> tagList = tagService.createTags(tags);
            question.setTagsQuestions(tagList);
            questionService.updateItem(question);
            return "redirect:/questions";   
        }
    }
}