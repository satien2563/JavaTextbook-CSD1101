package chap05_conditional;

import java.util.Scanner;

public class Ex5_3b_AgeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบอายุบรรลุนิติภาวะ");

        // รับค่าอายุจากผู้ใช้
        System.out.print("กรุณากรอกอายุ: ");
        int age = input.nextInt();

        // ตรวจสอบด้วย if-else
        if (age >= 18) {
            System.out.println("คุณมีอายุถึงเกณฑ์บรรลุนิติภาวะ");
        } else {
            System.out.println("คุณยังไม่ถึงเกณฑ์บรรลุนิติภาวะ");
        }

        input.close();
    }
}
