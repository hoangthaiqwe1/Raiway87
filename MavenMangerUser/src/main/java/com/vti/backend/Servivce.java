package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.User;
import com.vti.utils.JdbcConnection;

public class Servivce {
	public static List<User> usersList = new ArrayList<>();	
	public static void getOrInsertDepartment() throws SQLException {
		  Connection connection = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Scanner scanner = new Scanner(System.in);
	      
	      try {
	    	  connection = JdbcConnection.getConnection();
	    	  boolean continueInput = true;
	            while (continueInput) {
	                System.out.print("Nhập ID phòng ban được thêm: ");
	                int idDepartment = scanner.nextInt();
	                scanner.nextLine();

	                System.out.print("Nhập tên phòng ban được thêm: ");
	                String departmentName = scanner.nextLine();

	                String selectSql = "SELECT * FROM department WHERE department_name = ? OR id_department = ?";
	                pstmt = connection.prepareStatement(selectSql);
	                pstmt.setString(1, departmentName);
	                pstmt.setInt(2, idDepartment);
	                rs = pstmt.executeQuery();

	                if (rs.next()) {
	                    System.out.println("ID_Department: " + rs.getInt("id_department") + ", Department_name: " + rs.getString("department_name"));
	                    System.out.println("Dữ liệu đã tồn tại, không thể Insert");
	                } else {
	                    String insertSql = "INSERT INTO department (department_name) VALUES (?)";
	                    pstmt = connection.prepareStatement(insertSql);
	                    pstmt.setString(1, departmentName);
	                    int count = pstmt.executeUpdate();

	                    if (count > 0) {
	                        System.out.println("Thêm phòng ban thành công");
	                    } else {
	                        System.out.println("Thêm phòng ban thất bại");
	                    }
	                }
	                System.out.print("Bạn có muốn tiếp tục thêm phòng ban? (yes/no): ");
	                String userResponse = scanner.nextLine();

	                if (!userResponse.equalsIgnoreCase("yes")) {
	                    continueInput = false;
	                }
	    	  }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }finally{
	    	  JdbcConnection.closeConnection(connection, null , pstmt, rs);;
	      }
	  }		
	
	  public static void getOrInsertPosition() throws SQLException, FileNotFoundException, IOException {
	        Connection connection = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Scanner scanner = new Scanner(System.in);
	        try {
	            connection = JdbcConnection.getConnection();
	            boolean continueInput = true;
	            while (continueInput) {
	                System.out.print("Nhập ID chức Danh Được thêm: ");
	                int idPosition = scanner.nextInt();
	                scanner.nextLine(); 
	                System.out.print("Nhập tên chức danh được thêm: ");
	                String positionName = scanner.nextLine();
	                String selectSql = "SELECT * FROM position WHERE position_name = ? OR id_position = ?";
	                pstmt = connection.prepareStatement(selectSql);
	                pstmt.setString(1, positionName);
	                pstmt.setInt(2, idPosition);
	                rs = pstmt.executeQuery();

	                if (rs.next()) {
	                    System.out.println("ID_Position: " + rs.getInt("id_position") + ", Position_name: " + rs.getString("position_name"));
	                    System.out.println("Dữ liệu đã tồn tại, không thể Insert");
	                } else {
	                    String insertSql = "INSERT INTO position (position_name) VALUES (?)";
	                    pstmt = connection.prepareStatement(insertSql);
	                    pstmt.setString(1, positionName);
	                    int count = pstmt.executeUpdate();
	                    if (count > 0) {
	                        System.out.println("Thêm chức danh thành công");
	                    } else {
	                        System.out.println("Thêm chức danh thất bại");
	                    }
	                }
	                System.out.print("Bạn có muốn tiếp tục thêm chức danh? (yes/no): ");
	                String userResponse = scanner.nextLine();
	                if (!userResponse.equalsIgnoreCase("yes")) {
	                    continueInput = false;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JdbcConnection.closeConnection(connection, null, pstmt, rs);
	        }
	    }

	  public static void insertUser() throws SQLException {
	        Connection connection = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Scanner scanner = new Scanner(System.in);

	        try {
	            connection = JdbcConnection.getConnection();
	            boolean continueInput = true;
	            while (continueInput) {
	                System.out.print("Nhập Tên Phòng Ban: ");
	                String userName = scanner.nextLine();
	                System.out.print("Nhập ID phòng ban: ");
	                int idDepartment = scanner.nextInt();
	                System.out.print("Nhập ID chức danh: ");
	                int idPosition = scanner.nextInt();
	                scanner.nextLine();
	                String checkDeptSql = "SELECT id_department FROM department WHERE id_department = ?";
	                pstmt = connection.prepareStatement(checkDeptSql);
	                pstmt.setInt(1, idDepartment);
	                rs = pstmt.executeQuery();               
	                if (!rs.next()) {
	                    System.out.println("Phòng ban ko tồn tại. Vui lòng nhập ID phòng ban hợp lệ.");
	                    continue;
	                }  
	                String checkPosSql = "SELECT id_position FROM position WHERE id_position = ?";
	                pstmt = connection.prepareStatement(checkPosSql);
	                pstmt.setInt(1, idPosition);
	                rs = pstmt.executeQuery();	                
	                if (!rs.next()) {
	                    System.out.println("Chức danh ko tồn tại. Vui lòng nhập ID chức danh hợp lệ..");
	                    continue;
	                }                
	                String checkSql = "SELECT id_user FROM user WHERE user_name = ? AND id_department = ? AND id_position = ?";
	                pstmt = connection.prepareStatement(checkSql);
	                pstmt.setString(1, userName);
	                pstmt.setInt(2, idDepartment);
	                pstmt.setInt(3, idPosition);
	                rs = pstmt.executeQuery();
	                if (rs.next()) {
	                    System.out.println("Người dùng đã tồn tại. Không thể thêm mới.");
	                } else {
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
	                System.out.print("Bạn có muốn tiếp tục thêm User? (yes/no): ");
	                String userResponse = scanner.nextLine();

	                if (!userResponse.equalsIgnoreCase("yes")) {
	                    continueInput = false;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JdbcConnection.closeConnection(connection, null, pstmt, null);
	        }
	    }
	  public static void getUsersList() throws SQLException, FileNotFoundException, IOException {
		    Connection connection = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    try {
		        connection = JdbcConnection.getConnection();
		        String selectSql = "SELECT u.id_user, u.user_name, d.id_department, p.id_position, d.department_name, p.position_name " +
		                           "FROM user u " +
		                           "JOIN department d ON u.id_department = d.id_department " +
		                           "JOIN position p ON u.id_position = p.id_position";
		        pstmt = connection.prepareStatement(selectSql);
		        rs = pstmt.executeQuery();
		        usersList.clear(); 
		        while (rs.next()) {
		            int idUser = rs.getInt("id_user");
		            String userName = rs.getString("user_name");
		            String departmentName = rs.getString("department_name");
		            String positionName = rs.getString("position_name");
		            Department department = new Department(rs.getInt("id_department"), departmentName);
		            Position position = new Position(rs.getInt("id_position"), positionName);
		            User user = new User(idUser, userName, department, position);
		            usersList.add(user);
		        }
		        printUsers();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        JdbcConnection.closeConnection(connection, null, pstmt, rs);
		    }
		}

		public static void printUsers() {
		    for (User user : usersList) {
		        System.out.println("ID nhân viên: " + user.getId() +
		                           ", Tên nhân viên: " + user.getName() +
		                           ", Phòng ban: " + user.getDepartment().getName() +
		                           ", Chức danh: " + user.getPosition().getTitle());
		    }
		}
}
