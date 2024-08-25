package com.vti.backend.bussinesslayer;

import java.util.List;

import com.vti.backend.datalayer.DepartmentReponsitoryImpl;
import com.vti.backend.datalayer.IDepartmentReponsitory;
import com.vti.entity.Department;

public class DepartmentServiceImpl implements IDepartmentService{
	public IDepartmentReponsitory idepartmentreponsitory;
	public DepartmentServiceImpl() {
		idepartmentreponsitory = new DepartmentReponsitoryImpl();
	}
	@Override
	public boolean insertDepartment(String department_name) throws Exception {
		try {
			boolean flag= idepartmentreponsitory.checkDepartment(department_name);
			if(flag) {
				System.out.println("Dử liệu đã tồn tại");
				return false;
			}
			return idepartmentreponsitory.insertDepartment(department_name);
		}catch(Exception e) {
			return false;
		}
	}
	@Override
	public List<Department> getListDepartment() throws Exception {
		return idepartmentreponsitory.getListDepartment();
	}
	

}
