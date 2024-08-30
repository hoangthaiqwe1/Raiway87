package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;
import com.vti.entity.Employee;

public interface IEmployeeService {
	public abstract List<Employee> printEmployeesByProjectId(int projectId) throws SQLException;
}
