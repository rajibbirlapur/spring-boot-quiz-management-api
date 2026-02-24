package com.learning.quizapp.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({
	
	"questionId",
	"question",
    "optionA",
    "optionB",
    "optionC",
    "optionD"
	
})


@Data
public class QuestionWrapper 
{
	private Integer questionId;
	private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

	public QuestionWrapper(Integer questionId, String question, String optionA, String optionB, String optionC, String optionD) 
	{
		super();
		this.questionId = questionId;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}  
}
