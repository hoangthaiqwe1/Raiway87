package com.vti.backend;

import java.util.Random;
import java.util.Scanner;

import com.vti.dentity.Lottery;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Lottery lottery = new Lottery();
	     lottery.setNumberRandom8(3,2,100);
	     lottery.setNumberRandom7(3,3,1000);
	     lottery.setNumberRandom6(9,4,10000);
	     lottery.setNumberRandom5(3,4,10000);
	     lottery.setGiaiBon(21,5,100000);
	     lottery.setGiaiBa(6,5,100000);
	     lottery.setGiaiNhi(3,5,100000);
	     lottery.setGiaiNhat(3,5,100000);
	     lottery.setGiaiDacBiet(3,6,1000000);
	     Scanner scan = new Scanner(System.in);
	     // Hien thi ket qua giai 8
	     System.out.println("Kết Qủa Sổ Số Kiến Thiết");
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	     String[] giaiTam = lottery.getGiaitam();
	     System.out.print("Giải Tám: ");
	     for (String number : giaiTam) {
	         System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	       
	     // Hien thi ket qua giai 7   
	     String[] giaiBay = lottery.getGiaiBay();   
	     System.out.print("Giải Bảy: ");   
	     for (String number : giaiBay) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	       
	     // Hien thi ket qua giai 6
	     String[] giaiSau = lottery.getGiaiSau();
	     System.out.print("Giải Sáu: ");
	     for (String number : giaiSau) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	     // Hien thi ket qua giai 5
	     String[] giaiNam = lottery.getGiaiNam();
	     System.out.print("Giải Năm: ");
	     for (String number : giaiNam) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	  // Hien thi ket qua giai 4
	     String[] giaiTu = lottery.getGiaiBon();
	     System.out.print("Giải Bốn: ");
	     for (String number : giaiTu) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	  // Hien thi ket qua giai 3
	     String[] giaiBa = lottery.getGiaiBa();
	     System.out.print("Giải Ba: ");
	     for (String number : giaiBa) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	  // Hien thi ket qua giai 2
	     String[] giaiNhi = lottery.getGiaiNhi();
	     System.out.print("Giải Nhì: ");
	     for (String number : giaiNhi) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");	
		  // Hien thi ket qua giai 1
	     String[] giaiNhat = lottery.getGiaiNhat();
	     System.out.print("Giải Nhất: ");
	     for (String number : giaiNhat) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	     String[] giaiDacBiet = lottery.getGiaiDacBiet();
	     System.out.print("Giải Đặc Biệt: ");
	     for (String number : giaiDacBiet) {
	    	 System.out.print(number + " | ");
	     }
	     System.out.print("\n-----------------------------------------------------------------------------------------------------------------------------------\n");
	     System.out.print("Vui lòng nhập số vé của bạn (6 số): ");
	     String userTicket = scan.nextLine();
	     String result = resultLottery(lottery, userTicket);
	     System.out.println(result);
	}
	
	public static String resultLottery(Lottery lottery, String userTicket) {
		if (userTicket == null || userTicket.length() != 6) {
            return "Số vé số không hợp lệ, vui lòng Nhập lại 6 số.";
        }
        //check giai dac biet
		String result = checkPrizeCategory(lottery.getGiaiDacBiet(), userTicket, "Giải Đặc Biệt",userTicket);
        if (result != null) return result;

        // Check other prize categories
        if (userTicket.length() >= 5) {
            String numberMotGiaiHaiBaBon = userTicket.substring(1);
            result = checkPrizeCategory(lottery.getGiaiNhat(), numberMotGiaiHaiBaBon, "Giải Nhất",userTicket);
            if (result != null) return result;

            result = checkPrizeCategory(lottery.getGiaiNhi(), numberMotGiaiHaiBaBon, "Giải Nhì",userTicket);
            if (result != null) return result;

            result = checkPrizeCategory(lottery.getGiaiBa(), numberMotGiaiHaiBaBon, "Giải Ba",userTicket);
            if (result != null) return result;

            result = checkPrizeCategory(lottery.getGiaiBon(), numberMotGiaiHaiBaBon, "Giải Bốn",userTicket);
            if (result != null) return result;
        }

        if (userTicket.length() >= 4) {
            String numberNam = userTicket.substring(2);
            result = checkPrizeCategory(lottery.getGiaiNam(), numberNam, "Giải Năm",userTicket);
            if (result != null) return result;
        }

        if (userTicket.length() >= 4) {
            String numberSau = userTicket.substring(2);
            result = checkPrizeCategory(lottery.getGiaiSau(), numberSau, "Giải Sáu",userTicket);
            if (result != null) return result;
        }

        if (userTicket.length() >= 3) {
            String numberBay = userTicket.substring(3);
            result = checkPrizeCategory(lottery.getGiaiBay(), numberBay, "Giải Bảy",userTicket);
            if (result != null) return result;
        }

        if (userTicket.length() >= 2) {
            String numberGiaiTam = userTicket.substring(4);
            result = checkPrizeCategory(lottery.getGiaitam(), numberGiaiTam, "Giải Tám",userTicket);
            if (result != null) return result;
        }

        return "Xin chia buồn, Bạn đã không trúng giải nào!";
    }
	// check ket qua so so
	 private static String checkPrizeCategory(String[] prizeCategory, String userTicket, String prizeName,String numberLottery) {
	        for (String item : prizeCategory) {
	            if (item.equals(userTicket)) {
	                return "Chúc Mừng Bạn Đã Trúng " + prizeName +" Với Số Vé " + numberLottery + " !";
	            }
	        }
	        return null;
	    }

}
