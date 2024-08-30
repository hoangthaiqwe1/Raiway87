package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.JdbcConnection;

public class UserReponsitoryImpl implements IUserReponsitory{
	public boolean checkLogin(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {		
			try {
				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
}
