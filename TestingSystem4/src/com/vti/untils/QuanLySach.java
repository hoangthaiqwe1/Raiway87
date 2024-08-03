package com.vti.untils;

import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
	private List<TaiLieu> taiLieuList;  
	
	public QuanLySach() {
		this.taiLieuList = new ArrayList<>();
	}
	
	public void addTaiLieu(TaiLieu tailieu) {
		this.taiLieuList.add(tailieu);
	}
	
	public void viewTaiLieu() {
		for(TaiLieu tailieu : taiLieuList) {
			System.out.println(tailieu);
		}
	}
	
	  public void searchTaiLieu(Class<?> typeTaiLieu) {
	        for (TaiLieu tailieu : taiLieuList) {
	            if (typeTaiLieu.isInstance(tailieu)) {
	                System.out.println(tailieu);
	            }
	        }
	    }
	
	public void deleteTaiLieu(String maTaiLieu) {
		taiLieuList.removeIf(tailieu -> tailieu.getMaTaiLieu().equalsIgnoreCase(maTaiLieu));
	}
	
	public void exitProgram() {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
