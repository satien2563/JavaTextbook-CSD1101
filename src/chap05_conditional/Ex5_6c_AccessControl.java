package chap05_conditional;

import java.util.Scanner;

public class Ex5_6c_AccessControl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบสิทธิ์เข้าใช้งานระบบ");

        //รับค่า ชื่อผู้ใช้
        System.out.print("กรอกชื่อผู้ใช้: ");
        String username = input.nextLine();

        // กำหนดผู้ใช้ที่ถูกแบน (เช่น testuser)
        String bannedUser = "testuser";

        // ใช้ NOT (!) เพื่อตรวจสอบว่า "ไม่ใช่" ผู้ใช้ที่ถูกแบน
        if (!username.equalsIgnoreCase(bannedUser)) {
            System.out.println("เข้าสู่ระบบสำเร็จ: ยินดีต้อนรับ " + username);
        } else {
            System.out.println("การเข้าถึงถูกปฏิเสธ: ผู้ใช้ '" + bannedUser + "' ถูกระงับสิทธิ์");
        }

        input.close();
    }
}