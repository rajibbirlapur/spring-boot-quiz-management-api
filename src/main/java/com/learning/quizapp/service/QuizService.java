package com.learning.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.quizapp.dao.QuestionDao;
import com.learning.quizapp.dao.QuizDao;
import com.learning.quizapp.model.Question;
import com.learning.quizapp.model.QuestionWrapper;
import com.learning.quizapp.model.Quiz;
import com.learning.quizapp.model.Response;

@Service
public class QuizService 
{
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) 
	{
		Pageable pageable = PageRequest.of(0, numQ);
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, pageable);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success" , HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) 
	{
		Optional<Quiz> quiz = quizDao.findById(id);
		
		List<Question> questionsFromDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(Question q : questionsFromDB)
		{
			QuestionWrapper qWrapper = new QuestionWrapper(q.getQuestionId(), q.getQuestion(), q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD());
			questionsForUser.add(qWrapper);
		}
	
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) 
	{
		Quiz quiz = quizDao.findById(id).get();
		
		List<Question> questions = quiz.getQuestions();
		
		int right=0;
		int i=0;
		
		for(Response response : responses)
		{
			if(response.getResponse().equals(questions.get(i).getCorrectOption()))
				right++;
			
			i++;
		}
		return new ResponseEntity<> (right, HttpStatus.OK);
	}

}
