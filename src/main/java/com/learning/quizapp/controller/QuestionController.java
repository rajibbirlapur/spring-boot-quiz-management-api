package com.learning.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.quizapp.model.Question;
import com.learning.quizapp.service.QuestionService;

@RestController
@RequestMapping(path="/question")
public class QuestionController 
{
	@Autowired
	QuestionService questionService;
	
	@GetMapping(path = "/allquestion")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
    
	@GetMapping(path = "/category/{cat}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cat") String category)
	{
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping(path = "/addquestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
	}
	
	@PutMapping(path = "/updatequestion/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable("id") int questionId, @RequestBody Question question) 
	{
		return questionService.updateQuestion(questionId, question);  
	}
	
	@DeleteMapping(path = "/deletequestion/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") int questionId)
	{
		return questionService.deleteQuestion(questionId);
	}
	
	@GetMapping(path = "/questionid/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId)
	{
		return questionService.getQuestionById(questionId);
	}
}   
