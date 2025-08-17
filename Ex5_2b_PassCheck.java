package chap05_conditional;

import java.util.Scanner;

public class Ex5_2b_PassCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบผลสอบผ่านหรือตก");

        // รับค่าคะแนนสอบจากผู้ใช้
        System.out.print("กรุณากรอกคะแนนสอบ: ");
        int score = input.nextInt();

        // ใช้ if เพื่อตรวจสอบเงื่อนไข
        if (score >= 50) {
            System.out.println("ผลการสอบ: ผ่าน");
        }

        if (score < 50) {
            System.out.println("ผลการสอบ: ตก");
        }

        input.close();
    }
}
