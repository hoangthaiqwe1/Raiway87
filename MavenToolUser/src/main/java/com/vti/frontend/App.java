package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Department;
import com.vti.entity.Users;
import com.vti.utils.ScannerUtils;

public class App {	
	public static UserController usersController;
	public static DepartmentController departmentController;
	public App() {
		usersController = new UserController();
		departmentController = new DepartmentController();
	}
    public static void main( String[] args ) throws Exception{
      App app = new App();
      
      while (true) {
    	  	String account = ScannerUtils.inputName("Vui lòng nhập tên tài khoản: ");
    	  	String passlogin = ScannerUtils.inputName("Vui lòng nhập mật khẩu đăng nhập: ");
			boolean checkloginStatus = usersController.checkLogin(account, passlogin);
			while(checkloginStatus){
				menu();
				System.out.println("Vui lòng chọn số chức năng: ");
				int choice = ScannerUtils.inputInt("Vui lòng chọn số chức năng  tương ứng!");
				switch(choice) {
				case 1: 
					String departmentname = ScannerUtils.inputName("Vui lòng nhập tên phòng ban: ");
					try {
						departmentController.insertDepartment(departmentname);
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					String username = ScannerUtils.inputName("Vui lòng nhập tên nhân viên: ");
					System.out.println("Hiển thị danh sách phòng ban cho người dụng chọn: ");
					List<Department> Listdp = departmentController.getListDepartment();
					for (Department department : Listdp) {
						System.out.println(department);
					}
					System.out.println("Vui lòng nhập ID phòng ban có trong danh sách trên: ");
					int idDepartment = ScannerUtils.inputInt("Vui lòng nhập dử liệu là dạng số có trong danh sách trên!");
					String password = ScannerUtils.inputName("Vui long nhập mật khẩu cho nhân viên: ");
					usersController.insertUser(username, idDepartment, password);	
					break;
				case 3:
					List<Users> listUser = usersController.getListUsers();
					for (Users users : listUser) {
						System.out.println(users);
					}
					break;
				case 4:
					List<Department> listDepartment = departmentController.getListDepartment();
					for (Department department : listDepartment) {
						System.out.println(department);
					}
					break;
				case 5:
					System.out.println("Nhập ID user cần tìm kiếm: ");
					int idUser = ScannerUtils.inputInt("Vui lòng nhập dử liệu là dạng số !");
					Users usid = usersController.getUserByID(idUser);
					System.out.println(usid);
				case 6:
					System.out.println("Nhập ID user cần tìm kiếm: ");
					String userNameSearch  = ScannerUtils.inputName("Vui lòng nhập tên nhân viên cần tìm: ");
					Users usnames = usersController.getUserByName(userNameSearch);
					System.out.println(usnames);	
				case 7:	
					System.out.println("Đăng xuất thành công....");
					return;
				default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
				}
			}
      }

    }
    
    public static void menu() {
		System.out.println("\n\n //---------- Menu -----------//");
		System.out.println("1. Thêm phòng ban");
		System.out.println("2. Thêm Nhân Viên");
		System.out.println("3. Hiển thị danh sách nhân viên");
		System.out.println("4. Tim kiem phong ban theo ten");
		System.out.println("5. Tìm kiếm User theo ID");
		System.out.println("6. Tim kiếm User theo tên");
		System.out.println("7. Đăng xuất tài khoản");
		System.out.println("\n //---------- ~.~ -----------//");

	}
}
