package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.EmployeeServiceImpl;
import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.entity.Employee;

public class EmployeeController {
	public IEmployeeService iuserservice;
	public EmployeeController() {
		iuserservice = new EmployeeServiceImpl();
	}
	
	public List<Employee> printEmployeesByProjectId(int projectId) throws SQLException{
		return  iuserservice.printEmployeesByProjectId(projectId);
	}
}
