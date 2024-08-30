package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;


public interface IEmployeeReponsitory {
	public abstract List<Employee> printEmployeesByProjectId(int projectId) throws SQLException;

}
