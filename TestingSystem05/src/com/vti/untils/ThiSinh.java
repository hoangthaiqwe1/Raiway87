package com.vti.untils;

public class ThiSinh {
	private String soBaoDanh;
	private String hoTen;
	private String diaChi;
	private int mucUuTien;
	public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
	        this.soBaoDanh = soBaoDanh;
	        this.hoTen = hoTen;
	        this.diaChi = diaChi;
	        this.mucUuTien = mucUuTien;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getMucUuTien() {
		return mucUuTien;
	}
	public void setMucUuTien(int mucUuTien) {
		this.mucUuTien = mucUuTien;
	}
	
	 public String getKhoiThi() {
	        return "N/A";
	 }
	
    @Override
	public String toString() {
        return "Số báo danh: " + soBaoDanh + ", Họ tên: " + hoTen + ", Địa chỉ: " + diaChi + ", Mức ưu tiên: " + mucUuTien;
    }
}
