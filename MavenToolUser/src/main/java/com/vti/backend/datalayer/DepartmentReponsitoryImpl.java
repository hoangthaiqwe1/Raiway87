package com.vti.backend.datalayer;
import com.vti.utils.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.entity.Department;

public class DepartmentReponsitoryImpl implements IDepartmentReponsitory{
	public boolean checkDepartment(String department_name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			conn = com.vti.utils.JdbcConnection.getConnection();
			String sql = "Select * from department Where department_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department_name);
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
				com.vti.utils.JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkDepartmentID(int departmentID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			conn = com.vti.utils.JdbcConnection.getConnection();
			String sql = "Select * from department Where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentID);
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
				com.vti.utils.JdbcConnection.closeConnection(conn, null , pstmt, null, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean insertDepartment(String department_name) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = com.vti.utils.JdbcConnection.getConnection();
			String sql = "insert into department(`department_name`) values (?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department_name);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("Thêm Phòng ban thành công");
				return true;
			}
			else {
				System.out.println("Thêm Phòng ban thất bại");
				return false;
			}
		}catch(Exception e) {
			throw new Exception("Lỗi trong quá trình thêm phòng ban");
		}finally {
			try {
				com.vti.utils.JdbcConnection.closeConnection(conn, null, pstmt, null, null);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public List<Department> getListDepartment() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Department> Lisetdp = new ArrayList<>();
		try {
			conn = JdbcConnection.getConnection();
			String sql = "Select * from department";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String departmentName = rs.getString("department_name");
				Department dp = new Department(id,departmentName);
				Lisetdp.add(dp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				JdbcConnection.closeConnection(conn, null, pstmt, null, rs);	
		}
		return Lisetdp;
	}
}
