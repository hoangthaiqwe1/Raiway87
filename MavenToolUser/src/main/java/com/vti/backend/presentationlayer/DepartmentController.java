package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.bussinesslayer.DepartmentServiceImpl;
import com.vti.backend.bussinesslayer.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	public IDepartmentService idepartmentservice;
	public DepartmentController() {
		idepartmentservice = new DepartmentServiceImpl();
	}
	
	public boolean insertDepartment (String department_name) throws Exception{
		return idepartmentservice.insertDepartment(department_name);
	};
	
	public List<Department> getListDepartment() throws Exception{
		return idepartmentservice.getListDepartment();
	};
}
