package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.Servivce;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.User;
import com.vti.utils.JdbcConnection;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            menu();
            System.out.print("Vui lòng chọn số chức năng tyển menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        Servivce.getOrInsertDepartment();
                        break;
                    case 2:
                        Servivce.getOrInsertPosition();
                        break;
                    case 3:
                        Servivce.insertUser();
                        break;
                    case 4:
                        Servivce.getUsersList();
                        break;
                    case 5:
                        System.out.println("Thoát ứng dụng thành công...");
                        return;
                    default:
                        System.out.println("Dử liệu không hợp lệ, vui lòng nhập lại.");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void menu() {
		System.out.println("---------- QUẢN LÝ DỬ LIỆU NHÂN VIÊN-----------");
		System.out.println("1. Thêm hoặc lấy dử liệu phòng ban đã tồn tại");
		System.out.println("2. Thêm hoặc lấy dử liệu chức danh đã tồn tại");
		System.out.println("3. Thêm hoặc lấy dử liệu nhân viên đã tồn tại");
		System.out.println("4. Hiện thị danh sách user");
		System.out.println("5. Thoát ra khỏi ứng dụng");
		System.out.println("---------- kết thúc -----------");
		
	}
}
