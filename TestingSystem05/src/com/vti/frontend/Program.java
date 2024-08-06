package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.untils.ThiSinh;
import com.vti.untils.ThiSinhKhoiA;
import com.vti.untils.ThiSinhKhoiB;
import com.vti.untils.ThiSinhKhoiC;
import com.vti.untils.TuyenSinh;

public class Program {

    public static void main(String[] args) {
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- QUẢN LÝ THÍ SINH ----");
            System.out.println("1. Thêm mới thí sinh");
            System.out.println("2. Hiện thị thông tin của thí sinh");
            System.out.println("3. Tìm kiếm theo số báo danh");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập số báo danh: ");
                    String soBaoDanh = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhập mức ưu tiên (1, 2, 3): ");
                    int mucUuTien = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Nhập khối thi (A/B/C): ");
                    String khoiThi = scanner.nextLine();
                    ThiSinh thiSinh;
                    switch (khoiThi.toUpperCase()) {
                        case "A":
                            thiSinh = new ThiSinhKhoiA(soBaoDanh, hoTen, diaChi, mucUuTien);
                            break;
                        case "B":
                            thiSinh = new ThiSinhKhoiB(soBaoDanh, hoTen, diaChi, mucUuTien);
                            break;
                        case "C":
                            thiSinh = new ThiSinhKhoiC(soBaoDanh, hoTen, diaChi, mucUuTien);
                            break;
                        default:
                            System.out.println("Khối thi không hợp lệ.");
                            continue;
                    }
                    tuyenSinh.themThiSinh(thiSinh);
                    System.out.println("Thí sinh đã được thêm thành công.");
                    break;
                case 2:
                    tuyenSinh.hienThiThongTin();
                    break;
                case 3:
                    System.out.print("Nhập số báo danh để tìm kiếm: ");
                    String searchSoBaoDanh = scanner.nextLine();
                    ThiSinh foundThiSinh = tuyenSinh.timKiemTheoSoBaoDanh(searchSoBaoDanh);
                    if (foundThiSinh != null) {
                        System.out.println(foundThiSinh.toString() + ", Khối thi: " + foundThiSinh.getKhoiThi());
                    } else {
                        System.out.println("Không tìm thấy thí sinh với số báo danh: " + searchSoBaoDanh);
                    }
                    break;
                case 4:
                    tuyenSinh.thoat();
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
