package com.vti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnection {
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Properties pr = new Properties();
		pr.load(new FileInputStream(new File("src/resource/database.properties")));
		String url = pr.getProperty("url");
		String user = pr.getProperty("username");
		String password = pr.getProperty("passowrd");
		Connection connection = DriverManager.getConnection(url, user, password);
		if(connection != null) {
			System.out.println("Connection Ok");
		}else {
			System.out.println("Connection Error");
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection,Statement st , PreparedStatement pstmt , ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (st != null) {
			st.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	
	
	
	public static void getAllUsersInfo() throws SQLException {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        connection = getConnection();
	        String sql = "SELECT u.id_user , u.user_name, d.department_name, p.position_name " +
	                     "FROM user u " +
	                     "JOIN department d ON u.id_department = d.id_department " +
	                     "JOIN position p ON u.id_position = p.id_position";
	        pstmt = connection.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            String userName = rs.getString("user_name");
	            String departmentName = rs.getString("department_name");
	            String positionName = rs.getString("position_name");
	            System.out.println("Tên người dùng: " + userName);
	            System.out.println("Phòng ban: " + departmentName);
	            System.out.println("Chức danh: " + positionName);
	            System.out.println("---------------------------------");
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(connection, null, pstmt, rs);
	    }
	}
}
