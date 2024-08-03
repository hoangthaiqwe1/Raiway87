package com.vti.untils;

public class Sach extends TaiLieu{

	
	public Sach( String maTaiLieu, String nhaXuatBan, int soBanPhatHanh,String tenTacgia,int soTrang) {
		super( maTaiLieu, nhaXuatBan, soBanPhatHanh);
		this.tenTacgia = tenTacgia;
		this.soTrang = soTrang;
		// TODO Auto-generated constructor stub
	}
	private String tenTacgia;
	private int soTrang;
	
	  @Override
	    public String toString() {
	        return "Sach [Ten Tac Gia=" + tenTacgia + ", So Trang=" + soTrang + ", " + super.toString() + "]";
	    }
}
