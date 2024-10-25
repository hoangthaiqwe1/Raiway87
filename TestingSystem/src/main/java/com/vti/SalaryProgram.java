package com.vti;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;

public class SalaryProgram {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		System.out.println("***********GET ALL SALARYS***********");

		List<Salary> salarys = repository.getAllSalarys();

		for (Salary salary : salarys) {
			System.out.println(salary);
		}

//		System.out.println("\n\n***********GET SALARY BY ID***********");
//
//		Salary SalaryById = repository.getSalaryByID((short) 2);
//		System.out.println(SalaryById);
//
//		System.out.println("\n\n***********GET SALARY BY SALARYNAME***********");
//
//		Salary SalaryByName = repository.getSalaryByName(600);
//		System.out.println(SalaryByName);

//		System.out.println("\n\n***********CREATE SALARY***********");
//
//		Salary SalaryCreate = new Salary();
//		SalaryCreate.setSalaryName(Salary.SalaryName.PM);
//		repository.createSalary(SalaryCreate);

//		System.out.println("\n\n***********UPDATE SALARY 1***********");
//
//		repository.updateGroup((short) 3, 700);
//
//		System.out.println("\n\n***********UPDATE SALARY 2***********");
//
//		Salary SalaryUpdate = new Salary();
//		SalaryUpdate.setId((short) 2);
//		SalaryUpdate.setSalaryName(700);
//		repository.updateSalary(SalaryUpdate);
//
//		System.out.println("\n\n***********DELETE SALARYS***********");
//		repository.deleteSalary((short) 2);
//
//		System.out.println("***********CHECK SALARY EXISTS BY ID***********");
//		System.out.println(repository.isSalaryExistsByID((short) 1));
//
//		System.out.println("***********CHECK SALARY EXISTS BY NAME***********");
//		System.out.println(repository.isSalaryExistsByName(700));

	}
}
