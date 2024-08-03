package com.vti.untils;

public class CongNhan extends Canbo{
	public CongNhan(String name, int age, String gender, String address, int bac) {
		super(name, age, gender, address);
		this.bac = bac;
		// TODO Auto-generated constructor stub
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	private int bac;
	
	@Override
	public String toString() {
        return "CongNhan [Name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender() + ", Address=" + getAddress() + ", Level=" + bac + "]";
    }
}
