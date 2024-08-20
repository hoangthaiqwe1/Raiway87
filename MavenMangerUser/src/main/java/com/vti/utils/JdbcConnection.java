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
	
	
	 public static void getOrInsertDepartment(int idDepartment ,String departmentName) throws SQLException {
		  Connection connection = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	    	  connection = getConnection();
	    	  String selectSql  = "SELECT * FROM department WHERE department_name = ? or id_department = ?";
	    	  pstmt = connection.prepareStatement(selectSql );
	    	  pstmt.setString(1,departmentName);
	    	  pstmt.setInt(2,idDepartment);
	    	  rs = pstmt.executeQuery();
	    	  if (rs.next()) {
                 System.out.println("ID_Department: " + rs.getInt("id_department") + ", Department_name: " + rs.getNString("department_name"));
                 System.out.println("Dử liệu đã tồn tại không thể Insert");
              }
	    	  else {
	    		  String insertSql = "INSERT INTO department (department_name) VALUES (?)";
	    		  pstmt = connection.prepareStatement(insertSql);
	    		  pstmt.setString(1,departmentName);
	    		  int count = pstmt.executeUpdate();
	    		  if (count > 0) {
						System.out.println("Insert success");
	    		  }else {
						System.out.println("Insert Fail");
	    		  }
	    	  }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }finally{
	    	  closeConnection(connection, null , pstmt, rs);;
	      }
	  }		
	 
	public static void getOrInsertPosition(int idPosition ,String positionName) throws SQLException {
		  Connection connection = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	    	  connection = getConnection();
	    	  String selectSql  = "SELECT * FROM position WHERE position_name = ? or id_position = ?";
	    	  pstmt = connection.prepareStatement(selectSql);
	    	  pstmt.setString(1,positionName);
	    	  pstmt.setInt(2,idPosition);
	    	  rs = pstmt.executeQuery();
	    	  if (rs.next()) {
                System.out.println("ID_Position: " + rs.getInt("id_position") + ", Position_name: " + rs.getNString("position_name"));
                System.out.println("Dử liệu đã tồn tại không thể Insert");
             }
	    	  else {
	    		  String insertSql = "INSERT INTO position (position_name) VALUES (?)";
	    		  pstmt = connection.prepareStatement(insertSql );
	    		  pstmt.setString(1,positionName);
	    		  int count = pstmt.executeUpdate();
	    		  if (count > 0) {
						System.out.println("Insert success");
	    		  }else {
						System.out.println("Insert Fail");
	    		  }
	    	  }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }finally{
	    	  closeConnection(connection, null , pstmt, rs);;
	      }
	  }	
	
	public static void insertUser(String userName, int idDepartment, int idPosition) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            String checkSql = "SELECT id_user FROM user WHERE user_name = ? AND id_department = ? AND id_position = ?";
            pstmt = connection.prepareStatement(checkSql);
            pstmt.setString(1, userName);
            pstmt.setInt(2, idDepartment);
            pstmt.setInt(3, idPosition);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Người dùng đã tồn tại. Không thể thêm mới.");
            } else {
                // Thêm người dùng nếu không tồn tại
                String insertSql = "INSERT INTO user (user_name, id_department, id_position) VALUES (?, ?, ?)";
                pstmt = connection.prepareStatement(insertSql);
                pstmt.setString(1, userName);
                pstmt.setInt(2, idDepartment);
                pstmt.setInt(3, idPosition);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Người dùng đã được thêm thành công.");
                } else {
                    System.out.println("Không thể chèn người dùng.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, null, pstmt, null);
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
