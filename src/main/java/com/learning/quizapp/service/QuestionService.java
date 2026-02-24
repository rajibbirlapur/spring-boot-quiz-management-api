package com.learning.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.learning.quizapp.dao.QuestionDao;
import com.learning.quizapp.model.Question;

@Component
public class QuestionService 
{
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try
		{
		    return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) 
	{
		try 
		{
			return new ResponseEntity<>(questionDao.getQuestionByCategory(category) , HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) 
	{
		try 
		{
			questionDao.save(question);
			return new ResponseEntity<>("Saved", HttpStatus.CREATED);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> updateQuestion(int questionId, Question question) 
	{
		try 
		{
			questionDao.save(question);
			return new ResponseEntity<>("Updated", HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestion(int questionId) 
	{
		try 
		{
			questionDao.deleteById(questionId);
			return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Question> getQuestionById(int questionId) 
	{
		try 
		{
			return new ResponseEntity<> (questionDao.findById(questionId).get() , HttpStatus.OK);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<> (new Question(), HttpStatus.BAD_REQUEST);	
	}	
}
