package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IManagerService;
import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.backend.businesslayer.ManagerServiceImpl;
import com.vti.backend.businesslayer.EmployeeServiceImpl;
import com.vti.entity.Manager;

public class ManagerController {
	public IManagerService imanagerservice;
	public ManagerController() {
		imanagerservice = new ManagerServiceImpl();
	}
	public List<Manager> getAllManagers() throws SQLException{
		return imanagerservice.getAllManagers();
	}
	
}
