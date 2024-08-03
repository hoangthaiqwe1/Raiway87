package com.vti.untils;

public class KySu extends Canbo{
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}
	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
	public KySu(String name, int age, String gender, String address,String nganhDaoTao) {
		super(name, age, gender, address);
		this.nganhDaoTao = nganhDaoTao;
		// TODO Auto-generated constructor stub
	}
	private String nganhDaoTao;
	
	 @Override
	    public String toString() {
	        return "KySu [Name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender() + ", Address=" + getAddress() + ", TrainingIndustry=" + nganhDaoTao + "]";
	    }
}
