package com.vti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
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
	
	public static void closeConnection(Connection connection,Statement st , PreparedStatement pstmt,CallableStatement call , ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if(call !=null) {
			call.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

}
