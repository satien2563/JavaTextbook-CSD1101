package chap05_conditional;

import java.util.Scanner;

public class Ex5_2a_PositiveNegativeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบจำนวนบวกหรือลบ");

        // รับค่าจำนวนเต็มจากผู้ใช้
        System.out.print("กรุณากรอกจำนวนเต็ม: ");
        int number = input.nextInt();

        // ใช้ if เพื่อตรวจสอบเงื่อนไข
        if (number >= 0) {
            System.out.println("ค่าที่กรอกเป็นจำนวนบวกหรือศูนย์");
        }

        if (number < 0) {
            System.out.println("ค่าที่กรอกเป็นจำนวนลบ");
        }

        input.close();
    }
}
