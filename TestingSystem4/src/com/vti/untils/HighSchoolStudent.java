package com.vti.untils;

public class HighSchoolStudent extends Student{

	public HighSchoolStudent(String name, int id,String clazz,String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
	    this.desiredUniversity = desiredUniversity;
		// TODO Auto-generated constructor stub
	}
	
	private String clazz;
    private String desiredUniversity;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getDesiredUniversity() {
		return desiredUniversity;
	}
	public void setDesiredUniversity(String desiredUniversity) {
		this.desiredUniversity = desiredUniversity;
	}
	
	public String toString() {
        return "HighSchoolStudent [Id=" + getId() + ", Name=" + getName() + ", Class=" + clazz + ", Desired University=" + desiredUniversity + "]";
    }
}
