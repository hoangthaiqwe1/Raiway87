package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Manager;

public interface IManagerService {
	public abstract List<Manager> getAllManagers() throws SQLException;
}
