package com.vti.dentity;
import java.util.Random;
public class Lottery {
	private int numberRandom; // so random
	private int typeNumber; // kieu so tra ra
	private int limitNumber;// gioi han so
	private String[] giaitam;
	private String[] giaiBay;
	private String[] giaiSau;
	private String[] giaiNam;
	private String[] giaiBon;
	private String[] giaiBa;
	private String[] giaiNhi;
	private String[] giaiNhat;
	private String[] giaiDacBiet;
	// contructor ko tham so
	public Lottery(){};
	
	//-----------------------------------------------------------------------------------------
	//get mang Giai 8
	public String[] getGiaitam() {
        return giaitam;
    }
	// set giai 8
	public void setNumberRandom8(int numberRandom,int typeNumber, int limitNumber) {
        this.numberRandom = numberRandom;
        this.typeNumber = typeNumber;
        this.limitNumber = limitNumber;
        this.giaitam = randomNumber(numberRandom,typeNumber,this.giaitam ,limitNumber); 
    }
	//-----------------------------------------------------------------------------------------
	//get mang Giai 7
	public String[] getGiaiBay() {
        return giaiBay;
    }
	// set giai 7
	public void setNumberRandom7(int numberRandom,int typeNumber, int limitNumber) {
        this.numberRandom = numberRandom;
        this.typeNumber = typeNumber;
        this.giaiBay = randomNumber(numberRandom,typeNumber, this.giaiBay,limitNumber); 
    }
	//-----------------------------------------------------------------------------------------
	// get mang Giai 6
	public String[] getGiaiSau() {
	    return giaiSau;
	}
	// set giai 6
	public void setNumberRandom6(int numberRandom,int typeNumber, int limitNumber) {
        this.numberRandom = numberRandom;
        this.typeNumber = typeNumber;
        this.giaiSau = randomNumber(numberRandom,typeNumber, this.giaiSau,limitNumber); 
    }
	//-----------------------------------------------------------------------------------------
	// get mang Giai 5
	public String[] getGiaiNam() {
		    return giaiNam;
	}
	// set giai 5
	public void setNumberRandom5(int numberRandom,int typeNumber, int limitNumber) {
	    this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiNam = randomNumber(numberRandom,typeNumber, this.giaiNam,limitNumber); 
	}
	// get giai 4
	public String[] getGiaiBon() {
		return this.giaiBon;
	}
	// set giai 4
	public void setGiaiBon(int numberRandom,int typeNumber, int limitNumber) {
		this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiBon = randomNumber(numberRandom,typeNumber, this.giaiBon,limitNumber);
	}
	// get giai 3
	public String[] getGiaiBa() {
		return this.giaiBa;
	}
	// set giai 3
	public void setGiaiBa(int numberRandom,int typeNumber, int limitNumber) {
		this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiBa = randomNumber(numberRandom,typeNumber, this.giaiBa,limitNumber);
	}		
	// get giai 2
	public String[] getGiaiNhi() {
		return this.giaiNhi;
	}
	// set giai 2
	public void setGiaiNhi(int numberRandom,int typeNumber, int limitNumber) {
		this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiNhi = randomNumber(numberRandom,typeNumber, this.giaiNhi,limitNumber);
	}		
	// get giai 1
	public String[] getGiaiNhat() {
		return this.giaiNhat;
	}
	// set giai 1
	public void setGiaiNhat(int numberRandom,int typeNumber, int limitNumber) {
		this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiNhat = randomNumber(numberRandom,typeNumber, this.giaiNhat,limitNumber);
	}	
	// get giai Dac biet
	public String[] getGiaiDacBiet() {
		return this.giaiDacBiet;
	}
	// set giai Dac biet
	public void setGiaiDacBiet(int numberRandom,int typeNumber, int limitNumber) {
		this.numberRandom = numberRandom;
	    this.typeNumber = typeNumber;
	    this.giaiDacBiet = randomNumber(numberRandom,typeNumber, this.giaiDacBiet,limitNumber);
	}	
	
	
	// Ham thuc hien random ket qua so so
	public String[] randomNumber(int count,int number,String[] giai , int limitNumber) {
        Random random = new Random();
         giai = new String[count];
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(limitNumber); // Generates a number between 10 and 99
            giai[i] = String.format("%0"+ number +"d", num); // Formats number to 2 digits
        }
        return giai;
    }
}
