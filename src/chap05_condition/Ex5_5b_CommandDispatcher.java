package chap05_conditional;

import java.util.Scanner;

public class Ex5_5b_CommandDispatcher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตัวจัดการคำสั่งผู้ใช้ (Command Dispatcher)");

        // รับคำสั่ง
        System.out.print("กรุณากรอกคำสั่ง (login/logout/help/exit): ");
        String cmd = input.nextLine().trim().toLowerCase();

        // เลือกทำงานด้วย switch-case บน String (Java 7+)
        switch (cmd) {
            case "login":
                System.out.println("กำลังเข้าสู่ระบบ...");
                break;
            case "logout":
                System.out.println("กำลังออกจากระบบ...");
                break;
            case "help":
                System.out.println("วิธีใช้: พิมพ์ login, logout, help หรือ exit");
                break;
            case "exit":
                System.out.println("ออกจากโปรแกรมแล้ว");
                break;
            default:
                System.out.println("คำสั่งไม่ถูกต้อง");
        }

        input.close();
    }
}
