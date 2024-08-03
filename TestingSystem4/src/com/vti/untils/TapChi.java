package com.vti.untils;

public class TapChi extends TaiLieu{

	
	public TapChi( String maTaiLieu, String nhaXuatBan, int soBanPhatHanh,int soPhatHanh,int thangPhatHanh) {
		super( maTaiLieu, nhaXuatBan, soBanPhatHanh);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
		// TODO Auto-generated constructor stub
	}
	public int getSoPhatHanh() {
		return soPhatHanh;
	}
	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}
	public int getThangPhatHanh() {
		return thangPhatHanh;
	}
	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}
	private int soPhatHanh;
	private int thangPhatHanh;
	
	
	 @Override
	    public String toString() {
	        return "TapChi [So Phat Hanh=" + soPhatHanh + ", Thang Phat Hanh=" + thangPhatHanh + ", " + super.toString() + "]";
	    }
}
