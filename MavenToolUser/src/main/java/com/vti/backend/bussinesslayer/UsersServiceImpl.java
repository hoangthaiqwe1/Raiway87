package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.DepartmentReponsitoryImpl;
import com.vti.backend.datalayer.IDepartmentReponsitory;
import com.vti.backend.datalayer.IUserReponsitory;
import com.vti.backend.datalayer.UserReponsitoryImpl;
import com.vti.entity.Users;


public class UsersServiceImpl implements IUsersService{
	public IUserReponsitory iuserreponsitory;
	public IDepartmentReponsitory iDepartmentReponsitory;
	public UsersServiceImpl () {
		iuserreponsitory = new UserReponsitoryImpl();
		iDepartmentReponsitory = new DepartmentReponsitoryImpl();
	}

	public Users getUserByID(int id_user) {
		try {
	        Users us = iuserreponsitory.getUserByID(id_user);
	        if (us == null) {
	            return null;
	        }
	        return us;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Users getUserByName(String user_name) {
		try {
			Users us = iuserreponsitory.getUserByName(user_name);
	        if (us == null) {
	            return null;
	        }
	        return us;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public boolean insertUser(String username, int departmentID, String password) throws Exception {
		boolean flag = iuserreponsitory.checkUsers(username);
		boolean flag2 = iDepartmentReponsitory.checkDepartmentID(departmentID);
		if(flag || !flag2) {
			System.out.println("Dử liệu không hợp lệ không được Update.");
			return false;
		}	
		try {
			System.out.println("Dử liệu hợp lê được phép Update.");
			return iuserreponsitory.insertUser(username, departmentID, password);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkLogin(String username, String password) throws SQLException{
		try {
	        boolean flag = iuserreponsitory.checkLogin(username, password);
	        if (flag) {
	            System.out.println("Đăng nhập thành công");
	            return true;
	        } else {
	        	System.out.println("Đăng nhập thất bại");
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public List<Users> getListUsers() throws SQLException {
		 try {
		        List<Users> lstUser = iuserreponsitory.getListUsers();
		        return lstUser;
		    } catch (SQLException e) {
		        throw e;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
	};
}
