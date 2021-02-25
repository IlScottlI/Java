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

import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.models.TagQuestion;
import com.codingdojo.mvc.services.QuestionService;
import com.codingdojo.mvc.services.TagQuestionService;
import com.codingdojo.mvc.services.TagService;

@Controller
public class IndexController {
	
	   private final QuestionService questionService;
	   private final TagService tagService;
	   private final TagQuestionService tagQuestionService;
	   public IndexController(
			   QuestionService questionService,
			   TagService tagService,
			   TagQuestionService tagQuestionService
			   ) {
	        this.questionService = questionService;
	        this.tagService = tagService;
	        this.tagQuestionService = tagQuestionService;
	    }

    @RequestMapping("/questions")
    public String dashboard(Model model) {
    	List<Question> questions = questionService.allItems();
        model.addAttribute("questions", questions);
        questions.get(0).getTagsQuestions().forEach(System.out::println);
        return "dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(Model model) {
        return "new-question.jsp";
    }

    @RequestMapping("/questions/{id}")
    public String index(@PathVariable("id") Long id,@ModelAttribute("question") Question question, Model model) {
        return "view-question.jsp";
    }
    @RequestMapping(value = "/questions/new", method = RequestMethod.POST)
    public String newItem(
            @RequestParam(value="tags") String tags,
    		@Valid @ModelAttribute("question") Question question, 
    		BindingResult result
    		) {
        if (result.hasErrors()) {
            return "new-question.jsp";
        } else {
            Question newQuestion = questionService.createItem(question);
            List<Tag> tagList = tagService.createTags(tags);
            List<TagQuestion> tagQuestionList = tagQuestionService.associateItems(tagList,newQuestion);
            newQuestion.setTagsQuestions(tagQuestionList);
            if (newQuestion.getTagsQuestions().size()>0) {
            	return "redirect:/questions";
			}
            return "new-question.jsp";
            
        }
    }
}