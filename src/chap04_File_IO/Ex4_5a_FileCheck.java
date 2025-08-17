package chap04_File_IO;

// ตัวอย่างที่ 4.5a: ตรวจสอบสถานะของแฟ้มด้วยคลาส File
import java.io.File;

public class Ex4_5a_FileCheck {
    public static void main(String[] args) {
        File file = new File("src/chap04_File_IO/student.txt");

        if (file.exists()) {
            System.out.println("พบแฟ้ม: " + file.getName());
            if (file.isFile()) {
                System.out.println("เป็นแฟ้มข้อมูลธรรมดา");
            } else if (file.isDirectory()) {
                System.out.println("เป็นไดเรกทอรี");
            }

            System.out.println("สามารถอ่านได้: " + file.canRead());
            System.out.println("สามารถเขียนได้: " + file.canWrite());
            System.out.println("ขนาดแฟ้ม (byte): " + file.length());
        } else {
            System.out.println("ไม่พบแฟ้มที่ระบุ");
        }
    }
}
