package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.utils.JdbcConnection;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Thêm mới 3 phòng ban");
		JdbcConnection.getOrInsertDepartment(1,"Kế toán");
		JdbcConnection.getOrInsertDepartment(2,"IT planning");
		JdbcConnection.getOrInsertDepartment(3,"HR");
		System.out.println("====================================================");
		System.out.println("Thêm mới 3 chức danh");
		JdbcConnection.getOrInsertPosition(1,"Manager");
		JdbcConnection.getOrInsertPosition(2,"Officer");
		JdbcConnection.getOrInsertPosition(3,"Superviser");
		System.out.println("====================================================");
		System.out.println("Thêm mới 5 nhân viên");
		JdbcConnection.insertUser("HoangThai", 2, 1);
		JdbcConnection.insertUser("HoangThai", 2, 2);
		JdbcConnection.insertUser("Minh Tú", 1, 2);
		JdbcConnection.insertUser("Tuyết Ngân", 1, 1);
		JdbcConnection.insertUser("Lý Hùng Linh", 3, 3);
		System.out.println("====================================================");
		System.out.println("Danh sách các nhân viên");
		JdbcConnection.getAllUsersInfo();
	}
}
