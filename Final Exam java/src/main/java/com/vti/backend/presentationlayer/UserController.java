package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserServiceImpl;
import com.vti.backend.businesslayer.EmployeeServiceImpl;
import com.vti.entity.Employee;


public class UserController {
		public IUserService iuserservice ;
		public UserController() {
			iuserservice = new UserServiceImpl();
		}
	public boolean checkLogin(String email, String password) {
		final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		 if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
	         System.out.println("Email Không hợp lệ.");
	         return false;
		 }
	     if (password == null || password.length() < 6 || password.length() > 12) {
	         System.out.println("Vui lòng nhập password từ 6 đến 12 ký tự");
	         return false;
	     }
		return iuserservice.checkLogin(email, password);
	}
	
}
