package com.vti;

import java.util.Date;
import java.util.List;

import com.vti.repository.ExamRepository;
import com.vti.entity.Exam;

public class ExamProgram {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

//		System.out.println("***********GET ALL EXAMS***********");
//
//		List<Exam> exams = repository.getAllExams();
//
//		for (Exam exam : exams) {
//			System.out.println(exam);
//		}
//
//		System.out.println("\n\n***********GET EXAM BY ID***********");
//
//		Exam examById = repository.getExamByID((short) 2);
//		System.out.println(examById);
//
//		System.out.println("\n\n***********GET EXAM BY NAME***********");
//
//		Exam examByName = repository.getExamByName("Đề thi PHP");
//		System.out.println(examByName);

//		System.out.println("\n\n***********CREATE EXAM***********");
//
		Exam examCreate = new Exam();
		examCreate.setName("Đề thi ASP.NET1");
		examCreate.setDuration(180);
		repository.createExam(examCreate);

//		System.out.println("\n\n***********UPDATE EXAM 1***********");
//
//		repository.updateExam((short) 3,"S-1",null, "Security",60);
//
//		System.out.println("\n\n***********UPDATE EXAM 2***********");

//		Exam examUpdate = new Exam();
//		examUpdate.setId((short)1);
//		examUpdate.setCode1("S-1");
//		examUpdate.setCode2(null);
//		examUpdate.setName("waiting123467");
//		examUpdate.setDuration(60);
//		repository.updateExam(examUpdate);
//
//		System.out.println("\n\n***********DELETE EXAMS***********");
//		repository.deleteExam((short) 2);
//
//		System.out.println("***********CHECK EXAM EXISTS BY ID***********");
//		System.out.println(repository.isExamExistsByID((short) 1));
//
//		System.out.println("***********CHECK EXAM EXISTS BY NAME***********");
//		System.out.println(repository.isExamExistsByName("Security"));

	}
}
