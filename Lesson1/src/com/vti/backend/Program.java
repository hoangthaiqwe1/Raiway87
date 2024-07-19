package com.vti.backend;

import java.util.Date;

public class Program {

	public static void main(String[] args) {
		//doi tuong 1
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Phong HR";
		//doi tuong 2
		
		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Phong IT";
		//doi tuong 1
		Position position1 = new Position();
		position1.positionId = 1;	
		position1.positionName = "Quan ly";
		//doi tuong 2
		
		Position position2 = new Position();
		position2.positionId = 2;	
		position2.positionName = "User";
		
		//doi tuong 1
		User user1 = new User();
		user1.id = 1;	
		user1.email = "hoangthai@gmail.com";
		user1.fullname = "Dang le hoang thai";
		user1.department = department1;
		user1.gender = Gender.FEMALE;
		user1.dateOfBirth = new Date("2024/07/15");
		//doi tuong 2
				
		User user2 = new User();
		user2.id = 1;	
		user2.email = "hunglinh@gmail.com";
		user2.fullname = "ly hung linh";
		user2.department = department2;
		user2.gender = Gender.MALE;
		user2.dateOfBirth = new Date("2024/07/19");
		
		// System.out.println("Department id:" + department2.departmentID);
		//System.out.println("Department name:" + department2.departmentName);
		//System.out.println("Position id:" + position2.positionId);
		//System.out.println("Position name:" + position1.positionName);
		System.out.println("-----Thong tin user 1-----\n");
		
		System.out.println("Id:" + user1.id);
		System.out.println("Email:" + user1.email);
		System.out.println("Fullname:" + user1.fullname);
		System.out.println("Gender:" + user1.gender);
		System.out.println("Date of birth:" + user1.dateOfBirth + "\n");
		
		System.out.println("-----Thong tin user2-----\n");
		System.out.println("Id:" + user2.id);
		System.out.println("Email:" + user2.email);
		System.out.println("Fullname:" + user2.fullname);
		System.out.println("Gender:" + user2.gender);
		System.out.println("Date of birth:" + user2.dateOfBirth);
		
	}

}
