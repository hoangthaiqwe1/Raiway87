package com.vti.backend;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.vti.untils.Bao;
import com.vti.untils.Canbo;
import com.vti.untils.CongNhan;
import com.vti.untils.HighSchoolStudent;
import com.vti.untils.KySu;
import com.vti.untils.NhanVien;
import com.vti.untils.QLCB;
import com.vti.untils.QuanLySach;
import com.vti.untils.Sach;
import com.vti.untils.TapChi;

public class Programs {

	public static void main(String[] args) {
		// Excercise 5 cau 1:
		QLCB qlcb = new QLCB();
	    Scanner scanner = new Scanner(System.in);
		CongNhan cn = new CongNhan("HoangThai",24,"Nam","491/33 HVB",1);
		qlcb.addCanBo(cn);
		KySu ks = new KySu("HoangThai",24,"Nam","491/33 HVB","KySu");
		qlcb.addCanBo(ks);
		NhanVien nv = new NhanVien("HoangThai",24,"Nam","491/33 HVB","IT");
		qlcb.addCanBo(nv);
		
		
		// Excercise 5 cau 2:
//		actionQlcb(scanner, qlcb);
		
		// Excercise 5 cau 3:
//		HighSchoolStudent student = new HighSchoolStudent("Nam",1, "Chuyên Văn", "Đại học công nghệ");
//        System.out.println(student);
        
        // Excercise 5 cau 4:
        QuanLySach qltv = new QuanLySach();
        actionQlSach(scanner,qltv);
	}
	
	public static void actionQlcb(Scanner scanner, QLCB qlcb) {
	    while (true) {
	        System.out.println("1. Thêm mới cán bộ");
	        System.out.println("2. Tìm kiếm theo họ tên");
	        System.out.println("3. Hiện thị thông tin về danh sách các cán bộ");
	        System.out.println("4. Xóa cán bộ theo họ tên");
	        System.out.println("5. Thoát khỏi chương trình");
	        System.out.print("Chọn chức năng: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine();  

	        switch (choice) {
	            case 1:
	                System.out.print("Nhập tên: ");
	                String name = scanner.nextLine();
	                System.out.print("Nhập tuổi: ");
	                int age = scanner.nextInt();
	                scanner.nextLine();  
	                System.out.print("Nhập giới tính: ");
	                String gender = scanner.nextLine();
	                System.out.print("Nhập địa chỉ: ");
	                String address = scanner.nextLine();
	                System.out.print("Nhập loại cán bộ (1: Công nhân, 2: Kỹ sư, 3: Nhân viên): ");
	                int type = scanner.nextInt();
	                scanner.nextLine();  

	                switch (type) {
	                    case 1:
	                        System.out.print("Nhập bậc: ");
	                        int level = scanner.nextInt();
	                        scanner.nextLine();  
	                        CongNhan cn = new CongNhan(name, age, gender, address, level);
	                        qlcb.addCanBo(cn);
	                        break;
	                    case 2:
	                        System.out.print("Nhập ngành đào tạo: ");
	                        String trainingIndustry = scanner.nextLine();
	                        KySu ks = new KySu(name, age, gender, address, trainingIndustry);
	                        qlcb.addCanBo(ks);
	                        break;
	                    case 3:
	                        System.out.print("Nhập công việc: ");
	                        String job = scanner.nextLine();
	                        NhanVien nhanVien = new NhanVien(name, age, gender, address, job);
	                        qlcb.addCanBo(nhanVien);
	                        break;
	                    default:
	                        System.out.println("Loại cán bộ không hợp lệ!");
	                        break;
	                }
	                break;
	            case 2:
	                System.out.print("Nhập tên để tìm kiếm: ");
	                String searchName = scanner.nextLine();
	                List<Canbo> foundCanbo = qlcb.searchByName(searchName);
	                for (Canbo canbo : foundCanbo) {
	                    System.out.println(canbo);
	                }
	                break;
	            case 3:
	                qlcb.displayAllCanbo();
	                break;
	            case 4:
	                System.out.print("Nhập tên để xóa: ");
	                String deleteName = scanner.nextLine();
	                qlcb.deleteByName(deleteName);
	                break;
	            case 5:
	                qlcb.exitProgram();
	                break;
	            default:
	                System.out.println("Chức năng không hợp lệ!");
	                break;
	        }
	    }
	}
	
	public static void actionQlSach(Scanner scanner,QuanLySach qltv) {
		while (true) {
			System.out.println("1. Thêm mới tài liệu: Sách, Tạp chí, Báo");
            System.out.println("2. Xoá tài liệu theo mã tài liệu");
            System.out.println("3. Hiện thị thông tin về tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại: Sách, Tạp chí, Báo");
            System.out.println("5. Thoát khỏi chương trình");
            System.out.print("Chọn chức năng: ");
	        
	        int choice = scanner.nextInt();
	        scanner.nextLine(); 
	        switch(choice) {
	        case 1:
	        	System.out.print("Nhập mã tài liệu: ");
                String maTaiLieu = scanner.nextLine();
                System.out.print("Nhập tên nhà xuất bản: ");
                String nhaXuatBan = scanner.nextLine();
                System.out.print("Nhập số bản phát hành: ");
                int soBanPhatHanh = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Nhập loại tài liệu (1: Sách, 2: Tạp chí, 3: Báo): ");
                int type = scanner.nextInt();
                scanner.nextLine(); 
                switch (type) {
                case 1:
                    System.out.print("Nhập tên tác giả: ");
                    String tenTacGia = scanner.nextLine();
                    System.out.print("Nhập số trang: ");
                    int soTrang = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Sach sach = new Sach(maTaiLieu, nhaXuatBan, soBanPhatHanh, tenTacGia, soTrang);
                    qltv.addTaiLieu(sach);
                    break;
                case 2:
                    System.out.print("Nhập số phát hành: ");
                    int soPhatHanh = scanner.nextInt();
                    System.out.print("Nhập tháng phát hành: ");
                    int thangPhatHanh = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    TapChi tapChi = new TapChi(maTaiLieu, nhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh);
                    qltv.addTaiLieu(tapChi);
                    break;
                case 3:
                    System.out.print("Nhập ngày phát hành (yyyy-mm-dd): ");
                    String ngayPhatHanhStr = scanner.nextLine();
                    LocalDate ngayPhatHanh = LocalDate.parse(ngayPhatHanhStr);
                    Bao bao = new Bao(maTaiLieu, nhaXuatBan, soBanPhatHanh, ngayPhatHanh);
                    qltv.addTaiLieu(bao);
                    break;
                default:
                    System.out.println("Loại tài liệu không hợp lệ!");
                    break;
            }
            break;
	        case 2:
                System.out.print("Nhập mã tài liệu để xóa: ");
                String deleteId = scanner.nextLine();
                qltv.deleteTaiLieu(deleteId);
                break;
            case 3:
                qltv.viewTaiLieu();
                break;
            case 4:
                System.out.println("Nhập loại tài liệu cần tìm kiếm (1: Sách, 2: Tạp chí, 3: Báo): ");
                int searchType = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                switch (searchType) {
                    case 1:
                        qltv.searchTaiLieu(Sach.class);
                        break;
                    case 2:
                        qltv.searchTaiLieu(TapChi.class);
                        break;
                    case 3:
                        qltv.searchTaiLieu(Bao.class);
                        break;
                    default:
                        System.out.println("Loại tài liệu không hợp lệ!");
                        break;
                }
                break;
            case 5:
                qltv.exitProgram();
                break;
            default:
                System.out.println("Chức năng không hợp lệ!");
                break;
	        }
		}
	}	       
}
	


