package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programs {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	//cau 1: Viết lệnh cho phép người dung nhập 3 số nguyên
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		Scanner scan6 = new Scanner(System.in);
		Scanner scan7 = new Scanner(System.in);
		
		int result1 = getValidInt(scan,"Vui lòng nhập số nguyên thứ 1...");
		int result2 = getValidInt(scan,"Vui lòng nhập số nguyên thứ 2...");
		int result3 = getValidInt(scan,"Vui lòng nhập số nguyên thứ 3...");
		System.out.printf("Ba số nguyên là: " + result1 + ", " + result2 + ", " + result3 + "\n");
	
		// cau2 Viết lệnh cho phép người dung nhập 2 số thực
	
		 float number1 = getValidFloat(scan1, "Vui lòng nhập số thực thứ nhất: ");
	     float number2 = getValidFloat(scan1, "Vui lòng nhập số thực thứ hai: ");
	     System.out.println("Hai số thực là: " + number1 + " và " + number2);
		
		//cau 3 viết lệnh cho phép nhập họ và tên
		
		String myName = getMyName(scan2,"Vui lòng nhập họ: ","Vui lòng nhập Tên: ");
		System.out.println("Họ và tên của bạn là: " + myName + "\n");
	     
	 // cau 4 Viết lện cho phép người dung nhập ngày sinh nhật
	     
		String birthDate = getValidDate(scan3, "Vui lòng nhập ngày sinh nhật (dd/MM/yyyy): ");
		System.out.println("Ngày sinh nhật của bạn là: " + birthDate + "\n");
    
	  /* cau 5  Viết lệnh cho phép người dùng tạo account (viết thành method) 
		Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
		chương trình sẽ chuyển thành Position.Dev, Position.Test, 
		Position.ScrumMaster, Position.PM   */

		createAccount(scan4);
	     
	   // cau 6 Viết lệnh cho phép người dùng tạo department (viết thành method) 
		Department department = createDepartment(scan5);
		 System.out.println("Department đã tạo:");
	        System.out.println("ID: " + department.idDepartment);
	        System.out.println("Tên: " + department.nameDepartment);
	        System.out.println("Mô tả: " + department.descriptionDepartment);
	     
		// cau 7 Nhập số chẵn từ console 
		int result = getInt(scan6);
		 System.out.print("Số chẳn là: " + result);
		
		/* cau 8
		 Viết chương trình thực hiện theo flow sau: 
			Bước 1:  
			Chương trình in ra text "mời bạn nhập vào chức năng muốn sử 
			dụng" 
			Bước 2:  
			Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account 
			Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo 
			department 
			Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập 
			lại" và quay trở lại bước 1 	  
		  */ 
		inputIntValue(scan7);
		
		
		
		
	}
	
	//cau 1
	public static int getValidInt(Scanner scan, String prompt) {
		while(true) {
			System.out.print(prompt);
            if (scan.hasNextInt()) { 
               int number = scan.nextInt();
               return number;
            } else {
                System.out.println("Đây không phải là số nguyên. Vui lòng thử lại.");
                scan.next();
            }
		}
	}
	
	//cau 2
	public static float getValidFloat(Scanner scan, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine();
            
            if (input.matches("-?\\d*\\.\\d+")) { 
                float number = Float.parseFloat(input);
                return number;
            } else {
                System.out.println("Đây không phải là số thực. Vui lòng thử lại.");
            }
        }
    }
	
	//cau 3
	 
	public static String getMyName (Scanner scan, String prompt1, String prompt2) {
			String lastName;
	        String firstName;
	        while (true) {
	            System.out.print(prompt1);
	            lastName = scan.nextLine();
	            if (!lastName.matches(".*\\d.*")) {
	                break;
	            }
	            System.out.println("Tên họ không được chứa số. Vui lòng thử lại.");
	        }

	        while (true) {
	            System.out.print(prompt2);
	            firstName = scan.nextLine();
	            if (!firstName.matches(".*\\d.*")) {
	                break;
	            }
	            System.out.println("Tên không được chứa số. Vui lòng thử lại.");
	        }
		        return lastName + " " + firstName;
	}
		
	//cau 4
	public static String getValidDate(Scanner scan, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scan.nextLine();
			if(input.matches("\\d{2}/\\d{2}/\\d{4}")) {
				return input;
			}
			else {
				 System.out.println("Ngày không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
			}
		}
	}

	//cau 5
	public static void createAccount(Scanner scan) {
		 System.out.print("Vui lòng nhập tên người dùng: ");
	        String username = scan.nextLine();
	        String password;
	        while (true) {
	            System.out.print("Vui lòng nhập mật khẩu: ");
	            password = scan.nextLine();
	            if (password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$")) {
	                break;
	            }
	            System.out.println("Mật khẩu phải có ít nhất một chữ cái viết hoa, một ký tự đặc biệt, một số. Vui lòng thử lại.");
	        }
	        
	        Position position = null;
	        while (position == null) {
	            System.out.print("Vui lòng chọn vị trí (1: Dev, 2: Test, 3: ScrumMaster, 4: PM)");
	            int choice = scan.nextInt(); 
	            switch (choice) {
	                case 1:
	                    position = Position.Dev;
	                    break;
	                case 2:
	                    position = Position.Test;
	                    break;
	                case 3:
	                    position = Position.ScrumMaster;
	                    break;
	                case 4:
	                    position = Position.PM;
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
	            }
	        }
	        System.out.println("Tài khoản đã được tạo:");
	        System.out.println("Tên người dùng: " + username);
	        System.out.println("Mật khẩu: " + password);
	        System.out.println("Vị trí: " + position);	
	}

	//cau 6;	
	public static Department createDepartment(Scanner scan) {
		System.out.print("Vui lòng nhập IDdepartment: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.print("Vui lòng nhập tên department: ");
		String name = scan.nextLine();
		
		System.out.print("Vui lòng nhập mô tả department: ");
		String description = scan.nextLine();
		return new Department(id, name, description);
	}

	// cau 7
	public static int getInt(Scanner scan) {
		while(true) {
			 System.out.print("Vui lòng nhập một số chẵn: ");
			if(scan.hasNextInt()) {
				int number = scan.nextInt();
				if(number % 2 == 0) {
					return number;
				}
				else {
					System.out.println("Số bạn nhập không phải là số chẵn. Vui lòng thử lại.");
				}
			}
			else {
				System.out.println("Đây không phải là số nguyên. Vui lòng thử lại.");
				scan.next();
			}
		}
	}

	//cau 8
	public static void inputIntValue(Scanner scan) {
		 boolean keepRunning = true;
		while(keepRunning) {
			System.out.println("Chọn chức năng:");
            System.out.println("1 - Tạo tài khoản");
            System.out.println("2 - Tạo department");
            System.out.print("Nhập lựa chọn của bạn: ");

            if(scan.hasNextInt()) {
            	 int choice = scan.nextInt();
            	 scan.nextLine();
     			switch(choice) {
     			case 1:
     				createAccount(scan);
     				keepRunning= false;
     				break;
     			case 2:
     				Department department = createDepartment(scan);
     				 System.out.println("Department đã tạo:");
     				   System.out.println("ID: " + department.idDepartment);
     				   System.out.println("Tên: " + department.nameDepartment);
     			       System.out.println("Mô tả: " + department.descriptionDepartment);
     			       keepRunning= false;
     			       break;
     			 default :      
     				 System.out.println("Mời bạn nhập lại");
                      break;
     			}				
            }
            else {
            	System.out.println("Vui lòng nhập dử liệu là dạng số.");
            	scan.next();
            }
            
		}
	}
}



