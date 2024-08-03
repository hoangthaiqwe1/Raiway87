package com.vti.untils;

public class NhanVien extends Canbo{
	public NhanVien(String name, int age, String gender, String address,String congViec) {
		super(name, age, gender, address);
		this.congViec = congViec;
		// TODO Auto-generated constructor stub
	}
	public String getCongViec() {
		return congViec;
	}
	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
	private String congViec;
	
	 @Override
	    public String toString() {
	        return "NhanVien [Name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender() + ", Address=" + getAddress() + ", Job=" + congViec + "]";
	    }
}
