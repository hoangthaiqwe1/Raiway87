package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IUserReponsitory;
import com.vti.backend.datalayer.UserReponsitoryImpl;

public class UserServiceImpl implements IUserService{
	public IUserReponsitory iuserreponsitory;
	public  UserServiceImpl() {
		iuserreponsitory = new UserReponsitoryImpl();
	}
	@Override
	public boolean checkLogin(String email, String password) {
		return iuserreponsitory.checkLogin(email, password);
	}

}
