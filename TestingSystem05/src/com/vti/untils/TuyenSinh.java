package com.vti.untils;

import java.util.ArrayList;
import java.util.List;

import com.vti.backend.ITuyenSinh;

public class TuyenSinh implements ITuyenSinh {
	List<ThiSinh> danhSachThiSinh = new ArrayList<>();

	@Override
	public void themThiSinh(ThiSinh thiSinh) {
		// TODO Auto-generated method stub
		danhSachThiSinh.add(thiSinh);
	}

	@Override
	public void hienThiThongTin() {
		// TODO Auto-generated method stub
		for(ThiSinh thisinh : danhSachThiSinh) {
			System.out.println(thisinh);
		}
	}

	
	@Override
	public ThiSinh timKiemTheoSoBaoDanh(String soBaoDanh) {
		for(ThiSinh thisinh : danhSachThiSinh) {
			if(thisinh.getSoBaoDanh().equals(soBaoDanh)) {
				return thisinh;
			}
		}
		return null;
	}

	@Override
	public void thoat() {
		// TODO Auto-generated method stub
		System.out.println("Đã thoát khỏi chương trình.");
	}	
}
