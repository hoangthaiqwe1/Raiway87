package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Users;

public interface IUsersService {
	public abstract Users getUserByID(int id_user);
	public abstract Users getUserByName(String user_name);
	public abstract boolean insertUser(String username,int departmentID,String password) throws Exception;
	public abstract boolean checkLogin(String username, String password) throws SQLException;
	public abstract List<Users> getListUsers() throws SQLException;
}
