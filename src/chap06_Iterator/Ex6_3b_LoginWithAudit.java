package chap06_Iterator;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex6_3b_LoginWithAudit {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234"; // เพื่อการสอน ใช้ค่าคงที่ง่าย ๆ
    private static final int MAX_ATTEMPTS = 3;
    private static final String LOG_FILE = "audit.log";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;

        do {
            System.out.print("Username: ");
            String u = sc.nextLine().trim();
            System.out.print("Password: ");
            String p = sc.nextLine().trim();

            attempts++;
            if (u.equals(USERNAME) && p.equals(PASSWORD)) {
                loggedIn = true;
                log("SUCCESS", u, attempts, "Login successful");
                System.out.println("เข้าสู่ระบบสำเร็จ");
            } else {
                log("FAIL", u, attempts, "Invalid credentials");
                System.out.println("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("เหลือโอกาสอีก " + (MAX_ATTEMPTS - attempts) + " ครั้ง");
                }
            }
        } while (!loggedIn && attempts < MAX_ATTEMPTS);

        if (!loggedIn) {
            System.out.println("บัญชีถูกล็อกชั่วคราวเนื่องจากพยายามเกินจำนวนที่กำหนด");
        } else {
            // ส่วนนี้จำลองเมนูหลังเข้าสู่ระบบจริง
            System.out.println("ยินดีต้อนรับสู่ระบบจัดการข้อมูล");
        }
    }

    private static void log(String status, String user, int attempt, String message) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String line = String.format("%s | %s | user=%s | attempt=%d | %s",
                ts, status, user, attempt, message);
        try (PrintWriter pw = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            pw.println(line);
        } catch (IOException e) {
            System.out.println("ไม่สามารถเขียนไฟล์บันทึกได้: " + e.getMessage());
        }
    }
}
