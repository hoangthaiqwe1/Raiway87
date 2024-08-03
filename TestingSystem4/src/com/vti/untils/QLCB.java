package com.vti.untils;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
	private List<Canbo> canboList;
	public QLCB() {
        this.canboList = new ArrayList<>();
    }
	public void addCanBo(Canbo canbo) {
		this.canboList.add(canbo);
	}
	
	public List<Canbo> searchByName(String name){
		List<Canbo> result = new ArrayList<>();
		for (Canbo canbo : canboList) {
            if (canbo.getName().equalsIgnoreCase(name)) {
                result.add(canbo);
            }
        }
		return result;	
	}
	
	public void displayAllCanbo() {
        for (Canbo canbo : canboList) {
            System.out.println(canbo);
        }
    }
	
	public void deleteByName(String name) {
        canboList.removeIf(canbo -> canbo.getName().equalsIgnoreCase(name));
    }
	
	public void exitProgram() {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
