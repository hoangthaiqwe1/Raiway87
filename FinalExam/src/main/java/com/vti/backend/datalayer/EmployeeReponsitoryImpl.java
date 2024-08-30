package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.utils.JdbcConnection;
import com.vti.entity.Employee;


public class EmployeeReponsitoryImpl implements IEmployeeReponsitory{
	

	@Override
	public List<Employee> printEmployeesByProjectId(int projectId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		try {
			conn = JdbcConnection.getConnection();
			String sql = "SELECT id, full_name, email, password, project_id, pro_skill FROM User WHERE project_id = ? AND role = 'employee'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectId);
	        rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int projId = rs.getInt("project_id");
                String proSkill = rs.getString("pro_skill");
                Employee employee = new Employee(id, fullName, email, password, projId, proSkill);
                employees.add(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);	
		}
		return employees;
	}	
}




//get UsersByID
//	@Override
//	public Users getUserByID(int id_user) {
//		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; 
//		
//		try {
//			conn = com.vti.utils.JdbcConnection.getConnection();
//			String sql ="SELECT u.id, u.user_name, u.password, d.id AS department_id, d.department_name " +
//                 	"FROM users u " +
//                 	"JOIN department d ON u.department_id = d.id " +
//                 	"WHERE u.id = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, id_user);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				int ID =  rs.getInt("id");
//				String username = rs.getString("user_name");
//				String password = rs.getString("password");
//				return new Users(ID, username,password);
//
//			}else {
//				return null;
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally {
//			try {
//				com.vti.utils.JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	// get UsersByName
//	public Users getUserByName(String user_name) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; 
//		try {
//			conn = JdbcConnection.getConnection();
//			String sql = "SELECT u.id, u.user_name,u.password, d.id AS department_id, d.department_name " +
//             		"FROM users u " +
//             		"JOIN department d ON u.department_id = d.id " +
//             		"WHERE u.user_name = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user_name);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				int ID =  rs.getInt("id");
//				String username = rs.getString("user_name");
//				String password = rs.getString("password");
//				return new Users(ID, username,password);
//			}else {
//				return null;
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally {
//			try {
//				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	//Insert Users
//	public boolean insertUser(String username,int departmentID,String password) throws Exception {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//			try {
//				conn = JdbcConnection.getConnection();;
//				String sql = "INSERT INTO users (user_name, department_id, password) VALUES (?, ?, ?)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1,username);
//				pstmt.setInt(2,departmentID);
//				pstmt.setString(3,password);
//				int count = pstmt.executeUpdate();
//				if(count > 0 ) {
//					System.out.println("Insert Success");
//					return true;
//				}else {
//					System.out.println("Insert Fail");
//					return false;
//				}
//			}catch(Exception e) {
//				throw new Exception("Error during user addition");
//			}finally {
//				try {
//					JdbcConnection.closeConnection(conn, null, pstmt, null, null);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//	}
	
	//Check Name Users
//	@Override
//	public boolean checkUsers(String user_name) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; 
//		
//		try {
//			conn = JdbcConnection.getConnection();
//			String sql = "Select * from users Where user_name = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user_name);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				return true;
//			}else {
//				return false;
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally {
//			try {
//				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	//Check ID Users
//	public boolean checkIdUsers(int id_user) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; 
//		
//		try {
//			conn = JdbcConnection.getConnection();
//			String sql = "Select * from users Where id = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, id_user);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				return true;
//			}else {
//				return false;
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally {
//			try {
//				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	//Update Users
//	@Override
//	public boolean updateUserName(String dataUpdate, int id_user) throws Exception {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//			try {
//				conn = JdbcConnection.getConnection();;
//				String sql = "update users set user_name = ? where id = ? ";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1,dataUpdate);
//				pstmt.setInt(2,id_user);
//				int count = pstmt.executeUpdate();
//				if(count > 0 ) {
//					System.out.println("Update Success");
//					return true;
//				}else {
//					System.out.println("Update Fail");
//					return false;
//				}
//				
//				
//			}catch(Exception e) {
//				throw new Exception("Error while updating information");
//			}finally {
//				try {
//					JdbcConnection.closeConnection(conn, null, pstmt, null, null);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}	
//	}
	
	//Delete UsersByID
//	@Override
//	public boolean deleteUserByID(int id_user) throws Exception {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//			try {
//				conn = JdbcConnection.getConnection();;
//				String sql = "delete from users where id = ?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1,id_user);
//				int count = pstmt.executeUpdate();
//				if(count > 0 ) {
//					System.out.println("Delete Success");
//					return true;
//				}else {
//					System.out.println("Delete Fail");
//					return false;
//				}
//				
//			}catch(Exception e) {
//				throw new Exception("Error when deleting information");
//			}finally {
//				try {
//					JdbcConnection.closeConnection(conn, null, pstmt, null, null);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//	}
	
	// getList Users
//	public List<Users> getListUsers() throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Users> lstUser = new ArrayList<>();
//		try {
//			conn = JdbcConnection.getConnection();
//			String sql = "SELECT u.id, u.user_name,u.password ,d.id AS department_id, d.department_name " +
//            			"FROM users u " +
//            			"JOIN department d ON u.department_id = d.id ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int ID =  rs.getInt("id");
//				String username = rs.getString("user_name");
//				int departmentID = rs.getInt("department_id");
//				String password = rs.getString("password");
//				Users us = new Users(ID, username, password);
//				lstUser.add(us);
//			}
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {		
//				JdbcConnection.closeConnection(conn, null , pstmt, null, rs);	
//		}
//		return lstUser;
//	}	
//	}
//}
