package chap05_conditional;

import java.util.Scanner;

public class Ex5_5a_MenuCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมเมนูคำนวณพื้นฐาน");

        // รับข้อมูล
        System.out.print("กรุณากรอกค่า a: ");
        double a = input.nextDouble();
        System.out.print("กรุณากรอกค่า b: ");
        double b = input.nextDouble();

        // แสดงเมนู
        System.out.println("=== เมนู ===");
        System.out.println("1) บวก");
        System.out.println("2) ลบ");
        System.out.println("3) คูณ");
        System.out.println("4) หาร");
        System.out.print("กรุณาเลือกเมนู (1-4): ");
        int choice = input.nextInt();

        // เลือกทำงานด้วย switch-case
        switch (choice) {
            case 1:
                System.out.println("ผลลัพธ์: " + (a + b));
                break;
            case 2:
                System.out.println("ผลลัพธ์: " + (a - b));
                break;
            case 3:
                System.out.println("ผลลัพธ์: " + (a * b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("ไม่สามารถหารด้วยศูนย์ได้");
                } else {
                    System.out.println("ผลลัพธ์: " + (a / b));
                }
                break;
            default:
                System.out.println("เลือกเมนูไม่ถูกต้อง");
        }

        input.close();
    }
}
