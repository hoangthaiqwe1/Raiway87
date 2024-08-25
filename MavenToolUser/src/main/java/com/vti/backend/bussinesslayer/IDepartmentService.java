package com.vti.backend.bussinesslayer;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {
	public abstract boolean insertDepartment (String department_name) throws Exception;
	public abstract List<Department> getListDepartment() throws Exception;
}
