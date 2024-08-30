package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.utils.JdbcConnection;

public class ManagerReponsitoryImpl implements IManagerReponsitory{

	@Override
	public List<Manager> getAllManagers() throws SQLException {
		List<Manager> managers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcConnection.getConnection();
            String sql = "SELECT id, full_name, email, password, exp_in_year, project_id FROM User WHERE role = 'manager'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int expInYear = rs.getInt("exp_in_year");
                int projectId = rs.getInt("project_id");
                Manager manager = new Manager(id, fullName, email, password, expInYear, projectId);
                managers.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcConnection.closeConnection(conn, null , pstmt, null, rs);	
        }

        return managers;
	}

}
