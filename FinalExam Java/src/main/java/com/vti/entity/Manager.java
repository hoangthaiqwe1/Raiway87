package com.vti.entity;

public class Manager extends User{
	private int expInYear;
	private int projectId;
	
	public Manager(int id, String fullName, String email, String password,int expInYear,int projectId) {
		super(id, fullName, email, password);
		this.expInYear = expInYear;
        this.projectId = projectId;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String toString() {
	    return "Manager [id= " + id + ", fullName= " + fullName + ", email= " + email + ", password= " + password +
	           ", expInYea r=" + expInYear + ", projectId =" + projectId + "]";
	}
}
