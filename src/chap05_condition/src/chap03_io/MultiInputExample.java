package chap03_io;

import java.util.Scanner;

public class MultiInputExample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับค่าข้อมูลแต่ละชนิดจากผู้ใช้
        System.out.print("กรอกชื่อของคุณ: ");
        String name = input.nextLine();

        System.out.print("กรอกอายุของคุณ: ");
        int age = input.nextInt();

        System.out.print("กรอกเกรดเฉลี่ย (GPA): ");
        double gpa = input.nextDouble();

        System.out.print("คุณเป็นสมาชิกหรือไม่ (true/false): ");
        boolean isMember = input.nextBoolean();

        // แสดงผลข้อมูลที่รับมา
        System.out.println("\n--- ข้อมูลที่คุณกรอก ---");
        System.out.println("ชื่อ: " + name);
        System.out.println("อายุ: " + age + " ปี");
        System.out.println("เกรดเฉลี่ย: " + gpa);
        System.out.println("สถานะสมาชิก: " + isMember);
    }
}
