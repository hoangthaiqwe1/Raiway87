package com.vti;

import java.util.Date;
import java.util.List;


import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;
import com.vti.repository.TypeQuestionRepository;

public class TypeQuestionProgram {
	public static void main(String[] args) {
		TypeQuestionRepository repository = new TypeQuestionRepository();

//		System.out.println("***********GET ALL TYPEQUESTIONS***********");
//
//		List<TypeQuestion> typeQuestions = repository.getAllTypeQuestions();
//
//		for (TypeQuestion typeQuestion : typeQuestions) {
//			System.out.println(typeQuestion);
//		}
//
//		System.out.println("\n\n***********GET TYPEQUESTION BY ID***********");
//
//		TypeQuestion typeQuestionById = repository.getTypeQuestionByID((short) 1);
//		System.out.println(typeQuestionById);

//		System.out.println("\n\n***********GET TYPEQUESTION BY NAME***********");
//
//		TypeQuestion typeQuestionByName = repository.getTypeQuestionByName(1);
//		System.out.println(typeQuestionByName);

//		System.out.println("\n\n***********CREATE TYPEQUESTION***********");
//
		TypeQuestion typeQuestionCreate = new TypeQuestion();
		typeQuestionCreate.setTypeName(TypeName.MUTIPLECHOICE);
		repository.createTypeQuestion(typeQuestionCreate);
//
//		System.out.println("\n\n***********UPDATE TYPEQUESTION 1***********");
//
//		repository.updateTypeQuestion((short) 0, 1);
//
//		System.out.println("\n\n***********UPDATE TYPEQUESTION 2***********");

//		TypeQuestion typeQuestionUpdate = new TypeQuestion();
//		typeQuestionUpdate.setId((short) 2);
//		typeQuestionUpdate.setName(1);
//		repository.updateTypeQuestion(typeQuestionUpdate);
//
//		System.out.println("\n\n***********DELETE TYPEQUESTIONS***********");
//		repository.deleteTypeQuestion((short) 2);
//
//		System.out.println("***********CHECK TYPEQUESTION EXISTS BY ID***********");
//		System.out.println(repository.isTypeQuestionExistsByID((short) 1));
//
//		System.out.println("***********CHECK TYPEQUESTION EXISTS BY NAME***********");
//		System.out.println(repository.isTypeQuestionExistsByName(1));

	}
}
