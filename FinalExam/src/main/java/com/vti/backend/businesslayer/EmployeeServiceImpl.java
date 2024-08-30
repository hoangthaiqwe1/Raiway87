package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.backend.datalayer.IEmployeeReponsitory;
import com.vti.backend.datalayer.EmployeeReponsitoryImpl;
import com.vti.entity.Employee;


public class EmployeeServiceImpl implements IEmployeeService{
	public IEmployeeReponsitory iuserreponsitory;
	public EmployeeServiceImpl () {
		iuserreponsitory = new EmployeeReponsitoryImpl();
	}
	@Override
	public List<Employee> printEmployeesByProjectId(int projectId) throws SQLException {
			try {
		        List<Employee> employees = iuserreponsitory.printEmployeesByProjectId(projectId);
		        return employees;
		    } catch (SQLException e) {
		        throw e;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		}	  
}


