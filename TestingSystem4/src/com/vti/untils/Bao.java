package com.vti.untils;

import java.time.LocalDate;

public class Bao extends TaiLieu{


	public Bao( String maTaiLieu, String nhaXuatBan, int soBanPhatHanh,LocalDate ngayPhatHanh) {
		super( maTaiLieu, nhaXuatBan, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
		// TODO Auto-generated constructor stub
	}

	 public LocalDate getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	private LocalDate ngayPhatHanh;;
	
	 @Override
	    public String toString() {
	        return "Bao [Ngay Phat Hanh=" + ngayPhatHanh + ", " + super.toString() + "]";
	    }
}
