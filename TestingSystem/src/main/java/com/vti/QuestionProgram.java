package com.vti;

import java.util.Date;
import java.util.List;

import com.vti.entity.Question;
import com.vti.repository.QuestionRepository;

public class QuestionProgram {
	public static void main(String[] args) {
		QuestionRepository repository = new QuestionRepository();

//		System.out.println("***********GET ALL QUESTIONS***********");
//
//		List<Question> questions = repository.getAllQuestions();
//
//		for (Question question : questions) {
//			System.out.println(question);
//		}
//
//		System.out.println("\n\n***********GET QUESTION BY ID***********");
//
//		Question questionById = repository.getQuestionByID((short) 2);
//		System.out.println(questionById);
//
//		System.out.println("\n\n***********GET QUESTION BY NAME***********");
//
//		Question questionByName = repository.getQuestionByName("Câu Hỏi về PHP");
//		System.out.println(questionByName);

//		System.out.println("\n\n***********CREATE QUESTION***********");
//
//		Question questionCreate = new Question();
//		questionCreate.setName("waiting12346");
//		repository.createQuestion(questionCreate);

//		System.out.println("\n\n***********UPDATE QUESTION 1***********");
//
//		repository.updateQuestion((short) 3, "Security");

//		System.out.println("\n\n***********UPDATE QUESTION 2***********");
//
//		Question questionUpdate = new Question();
//		questionUpdate.setId((short) 2);
//		questionUpdate.setName("Security2");
//		questionUpdate.setCreateDate(new Date());
//		repository.updateQuestion(questionUpdate);
//
//		System.out.println("\n\n***********DELETE QUESTIONS***********");
//		repository.deleteQuestion((short) 2);
//
//		System.out.println("***********CHECK QUESTION EXISTS BY ID***********");
//		System.out.println(repository.isQuestionExistsByID((short) 1));
//
//		System.out.println("***********CHECK QUESTION EXISTS BY NAME***********");
//		System.out.println(repository.isQuestionExistsByName("Security"));

	}
}
