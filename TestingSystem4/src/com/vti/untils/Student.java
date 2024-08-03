package com.vti.untils;

public abstract class Student extends Person{
	public Student(String name,int id) {
		super(name);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
}
