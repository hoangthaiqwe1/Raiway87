package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentReponsitory {
	public abstract boolean checkDepartment(String department_name);
	public abstract boolean insertDepartment (String department_name) throws Exception;
	public abstract List<Department> getListDepartment()throws SQLException;
	public abstract boolean checkDepartmentID(int departmentID);
}
