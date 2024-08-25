package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.DepartmentServiceImpl;
import com.vti.backend.bussinesslayer.IDepartmentService;
import com.vti.backend.bussinesslayer.IUsersService;
import com.vti.backend.bussinesslayer.UsersServiceImpl;
import com.vti.entity.Users;

public class UserController {
	public IUsersService iuserservice;
	public UserController() {
		iuserservice = new UsersServiceImpl();
	}
	public Users getUserByID(int id_user) {
		return  iuserservice.getUserByID(id_user);
	}
	
	public Users getUserByName(String user_name) {
		return iuserservice.getUserByName(user_name);
	}
	
	public boolean insertUser(String username,int departmentID,String password) throws Exception{
		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		
			if(!password.matches(passwordPattern)) {
				System.out.println("Password khong hop le vui long kiem tra lai!");
				return false;
			}
		return iuserservice.insertUser(username, departmentID, password);
	};
	
	public List<Users> getListUsers() throws SQLException{
		return iuserservice.getListUsers();
	};
	
	public boolean checkLogin(String username, String password) throws SQLException {
		return iuserservice.checkLogin(username, password);
	}
}
