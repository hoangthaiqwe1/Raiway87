package com.vti.backend;

import com.vti.untils.ThiSinh;

public interface ITuyenSinh {
	
	public void themThiSinh(ThiSinh thiSinh);
	public void hienThiThongTin();
	ThiSinh timKiemTheoSoBaoDanh(String soBaoDanh);
	public void thoat();
}
