package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IManagerReponsitory;
import com.vti.backend.datalayer.IEmployeeReponsitory;
import com.vti.backend.datalayer.ManagerReponsitoryImpl;
import com.vti.backend.datalayer.EmployeeReponsitoryImpl;
import com.vti.entity.Employee;
import com.vti.entity.Manager;

public class ManagerServiceImpl implements IManagerService {
	public IManagerReponsitory imanagerreponsitory;
	public ManagerServiceImpl () {
		imanagerreponsitory = new ManagerReponsitoryImpl();
	}
	@Override
	public List<Manager> getAllManagers() throws SQLException {
		try {
			List<Manager> managers = imanagerreponsitory.getAllManagers();
	        return managers;
	    } catch (SQLException e) {
	        throw e;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
