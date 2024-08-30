package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;

public interface IManagerReponsitory {
	public abstract List<Manager> getAllManagers() throws SQLException;
}
