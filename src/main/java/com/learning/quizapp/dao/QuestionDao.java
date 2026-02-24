package com.learning.quizapp.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{

	List<Question> getQuestionByCategory(String category);
	
    @Query(value = " SELECT * FROM question q WHERE q.category = :category ORDER BY q.question_id ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(@Param("category") String category, Pageable pageable);
	

	

}
