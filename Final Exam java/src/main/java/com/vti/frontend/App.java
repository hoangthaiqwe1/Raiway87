package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.vti.backend.presentationlayer.EmployeeController;
import com.vti.backend.presentationlayer.ManagerController;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.utils.JdbcConnection;
import com.vti.utils.ScannerUtils;

/**
 * Hello world!
 *
 */
public class App 
{	
	public static EmployeeController employeecontroller;
	public static UserController usercontroller ;
	public static ManagerController managercontroller ;
	public App() {
		employeecontroller =  new  EmployeeController();
		usercontroller = new UserController();
		managercontroller = new ManagerController();
	}
    public static void main( String[] args ) throws Exception{	
    	App app = new App(); 
    	boolean isLoginSuccessful = false;
    	 while (!isLoginSuccessful) {
             String email = ScannerUtils.inputName("Vui lòng nhập tên tài khoản là email: ");
             String password = ScannerUtils.inputName("Vui lòng nhập mật khẩu đăng nhập: ");

             isLoginSuccessful = usercontroller.checkLogin(email, password);
             if (!isLoginSuccessful) {
                 System.out.println("Đăng nhập không thành công. Vui lòng kiểm tra lại email hoặc mật khẩu.");
             }
             else {
            	 System.out.println("Đăng nhập thành công");
             }
         }

         while (isLoginSuccessful) {
             menu();
             System.out.println("Vui lòng chọn số chức năng: ");
             int choice = ScannerUtils.inputInt("Vui lòng chọn số chức năng tương ứng!");

             switch (choice) {
                 case 1:
                     System.out.println("Vui lòng nhập ID project của employee cần tìm kiếm: ");
                     int idproject = ScannerUtils.inputInt("Vui lòng nhập Project ID là số nguyên");
                     List<Employee> employees = employeecontroller.printEmployeesByProjectId(idproject);
                     if (employees != null && !employees.isEmpty()) {
                         for (Employee employee : employees) {
                             System.out.println(employee);
                         }
                     } else {
                         System.out.println("Không có nhân viên nào trong dự án với ID đã nhập.");
                     }
                     break;

                 case 2:
                     List<Manager> managers = managercontroller.getAllManagers();
                     if (managers != null && !managers.isEmpty()) {
                         for (Manager manager : managers) {
                             System.out.println(manager);
                         }
                     } else {
                         System.out.println("Không có danh sách Manager để hiển thị");
                     }
                     break;

                 case 3:
                     System.out.println("Đăng xuất thành công....");
                     return;

                 default:
                     System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                     break;
             }
         }
     }
    
    // Menu
		  public static void menu() {
				System.out.println("\n\n//---------- Menu -----------//\n ");
				System.out.println("1. Nhập ID project cần tìm kiếm của employee ");
				System.out.println("2. Hiển thi tất cả Manager của các project ");
				System.out.println("3. Đăng xuất tài khoản");
				System.out.println("\n//---------- ~.~ -----------//");
		
			}
   }


