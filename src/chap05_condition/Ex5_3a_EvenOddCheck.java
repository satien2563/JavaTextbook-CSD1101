package chap05_conditional;

import java.util.Scanner;

public class Ex5_3a_EvenOddCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบเลขคู่หรือเลขคี่");

        // รับค่าจำนวนเต็มจากผู้ใช้
        System.out.print("กรุณากรอกจำนวนเต็ม: ");
        int number = input.nextInt();

        // ตรวจสอบด้วย if-else
        if (number % 2 == 0) {
            System.out.println("ค่าที่กรอกเป็นเลขคู่");
        } else {
            System.out.println("ค่าที่กรอกเป็นเลขคี่");
        }

        input.close();
    }
}
