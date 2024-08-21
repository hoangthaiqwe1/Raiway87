package com.vti.entity;

public class User {
    private int id;
    private String name;
    private Department department;
    private Position position;

    public User(int id, String name, Department department, Position position) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
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

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
