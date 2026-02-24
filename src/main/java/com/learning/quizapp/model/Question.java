package com.learning.quizapp.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@JsonPropertyOrder(
{
    "questionId",
    "category",
    "level",
    "question",
    "optionA",
    "optionB",
    "optionC",
    "optionD"
})

@Data
@Entity
public class Question 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private Integer questionId;
	private String category;
	private String level;
	private String question;
	@Column(name="option_a")
    private String optionA;
	@Column(name="option_b")
    private String optionB;
	@Column(name="option_c")
    private String optionC;
	@Column(name="option_d")
    private String optionD;
	@Column(name="correct_option")
    private String correctOption;
}
