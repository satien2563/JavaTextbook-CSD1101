package chap03_io;

import java.util.Scanner;

public class ScannerImportExample {
    public static void main(String[] args) {
        // สร้างอ็อบเจกต์ Scanner เพื่อรับข้อมูลจากผู้ใช้
        Scanner input = new Scanner(System.in);

        // รับข้อมูลชื่อผู้ใช้
        System.out.print("กรุณากรอกชื่อของคุณ: ");
        String name = input.nextLine();

        // แสดงผลข้อมูลที่ได้รับ
        System.out.println("ยินดีต้อนรับคุณ " + name);
    }
}
