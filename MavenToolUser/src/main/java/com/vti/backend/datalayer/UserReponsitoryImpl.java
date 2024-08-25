package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.utils.JdbcConnection;
import com.vti.entity.Department;
import com.vti.entity.Users;

public class UserReponsitoryImpl implements IUserReponsitory{

	@Override
	public Users getUserByID(int id_user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			conn = com.vti.utils.JdbcConnection.getConnection();
			String sql ="SELECT u.id, u.user_name, u.password, d.id AS department_id, d.department_name " +
                    	"FROM users u " +
                    	"JOIN department d ON u.department_id = d.id " +
                    	"WHERE u.id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id_user);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int ID =  rs.getInt("id");
				String username = rs.getString("user_name");
				int departmentID = rs.getInt("department_id");
				String password = rs.getString("password");
				String departmentname = rs.getNString("department_name");
				Department dp = new Department(departmentID,departmentname);
 				return new Users(ID, username,password, dp);

			}else {
				return null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				com.vti.utils.JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Users getUserByName(String user_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT u.id, u.user_name,u.password, d.id AS department_id, d.department_name " +
                		"FROM users u " +
                		"JOIN department d ON u.department_id = d.id " +
                		"WHERE u.user_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int ID =  rs.getInt("id");
				String username = rs.getString("user_name");
				int departmentID = rs.getInt("department_id");
				String password = rs.getString("password");
				String departmentname = rs.getNString("department_name");
				Department dp = new Department(departmentID,departmentname);
 				return new Users(ID, username,password, dp);
			}else {
				return null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertUser(String username,int departmentID,String password) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
			try {
				conn = JdbcConnection.getConnection();;
				String sql = "INSERT INTO users (user_name, department_id, password) VALUES (?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				pstmt.setInt(2,departmentID);
				pstmt.setString(3,password);
				int count = pstmt.executeUpdate();
				if(count > 0 ) {
					System.out.println("Thêm Users thành công");
					return true;
				}else {
					System.out.println("Thêm Users thất bại");
					return false;
				}
			}catch(Exception e) {
				throw new Exception("lỗi trong quá trình thêm user");
			}finally {
				try {
					JdbcConnection.closeConnection(conn, null, pstmt, null, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	}
	
	@Override
	public boolean checkUsers(String user_name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			conn = JdbcConnection.getConnection();
			String sql = "Select * from users Where user_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Users> getListUsers() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Users> lstUser = new ArrayList<>();
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT u.id, u.user_name,u.password ,d.id AS department_id, d.department_name " +
            			"FROM users u " +
            			"JOIN department d ON u.department_id = d.id ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int ID =  rs.getInt("id");
				String username = rs.getString("user_name");
				int departmentID = rs.getInt("department_id");
				String password = rs.getString("password");
				String departmentname = rs.getNString("department_name");
				Department dp = new Department(departmentID,departmentname);
				Users us = new Users(ID, username, password, dp);
				lstUser.add(us);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);	
		}
		return lstUser;
	}	
	
	public boolean checkLogin(String username, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
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
