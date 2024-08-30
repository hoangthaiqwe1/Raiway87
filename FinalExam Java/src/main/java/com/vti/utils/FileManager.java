package com.vti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    public boolean isFileExits(String pathFile) {
        File file = new File(pathFile);
        if (file.exists()) {
            System.out.println("Tệp đã tồn tại.");
            return true;
        } else {
            System.out.println("Tệp không tồn tại.");
            return false;
        }
    }
	
	public void createNewFile(String pathFile) {
		boolean check = isFileExits(pathFile);
		if(!check) {
			File file = new File(pathFile);
			try {
             boolean result = file.createNewFile();
             if (result) {
                 System.out.println("Tệp đã được tạo thành công.");
             } else {
                 System.out.println("Tệp đã tồn tại hoặc không thể tạo tệp.");
             }
         } catch (Exception e) {
             System.out.println("Đã xảy ra lỗi khi tạo tệp.");
         };
		}else {
         System.out.println("Tệp đã tồn tại.");
     }
	}
	
	public void deleteFile(String pathFile) {
		boolean check = isFileExits(pathFile);
		if(check) {
			File file = new File(pathFile);
			try {
				boolean result = file.delete();
				if (result) {
	                 System.out.println("Tệp đã được xóa thành công.");
	             } else {
	                 System.out.println("Tệp đã không tồn tại hoặc không thể xóa tệp.");
	             }
			}catch(Exception e) {
				System.out.println("Đã xảy ra lỗi khi Xóa tệp.");
			}
		}else {
			System.out.println("Tệp đã không tồn tại.");
		}
	}
	
	public void readFile(String pathFile) {
        File file = new File(pathFile);
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] b = new byte[1024];
            int length;
            while ((length = in.read(b)) > -1) {
                String content = new String(b, 0, length);
                System.out.println("Nội dung: " + content);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }

    public void writeFile(String pathFile, String content) {
    	boolean check = isFileExits(pathFile);
    	if(check) {
    		File file = new File(pathFile);
    		try {
    			FileOutputStream ot = new FileOutputStream(file);
    			ot.write(content.getBytes());
    			System.out.println("Tệp đã được ghi thành công.");
            } catch (IOException e) {
                System.err.println("Lỗi khi ghi vào tệp: " + e.getMessage());
            }
    	}
    	else {
			System.out.println("Tệp đã không tồn tại.");
		}
    }
}
