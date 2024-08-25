package com.vti.entity;

public class Users {
    private int id;
    private String name;
    private String password; 
    private Department department;

    public Users(int id, String name,String password ,Department department) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.department = department;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id +" | UserName: " + name + " | DeparmentID: " + department.getId() + " | DeparmentName: " + department.getName() + " | Password: " + password;
	}
}
