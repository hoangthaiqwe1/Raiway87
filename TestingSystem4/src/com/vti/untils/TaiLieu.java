package com.vti.untils;

public class TaiLieu {
	private String fullName;
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private String nameTaiLieu;
	private String maTaiLieu;
	private String nhaXuatBan;
	private int soBanPhatHanh;
	
	public TaiLieu(String maTaiLieu,String nhaXuatBan,int soBanPhatHanh) {
		this.maTaiLieu = maTaiLieu;
		this.nhaXuatBan  = nhaXuatBan;
		this.soBanPhatHanh = soBanPhatHanh;
	}


	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}
	
	 @Override
	    public String toString() {
	        return "TaiLieu [Ma Tai Lieu=" + maTaiLieu + ", Nha Xuat Ban=" + nhaXuatBan + ", So Ban Phat Hanh=" + soBanPhatHanh + "]";
	    }
}
