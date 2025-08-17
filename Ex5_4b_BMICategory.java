package chap05_conditional;

import java.util.Scanner;

public class Ex5_4b_BMICategory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมจัดหมวดหมู่ดัชนีมวลกาย (BMI)");

        // รับค่าน้ำหนักและส่วนสูง
        System.out.print("กรุณากรอกน้ำหนัก (กิโลกรัม): ");
        double weight = input.nextDouble();
        System.out.print("กรุณากรอกส่วนสูง (เมตร): ");
        double height = input.nextDouble();

        // คำนวณ BMI
        double bmi = weight / (height * height);
        System.out.printf("ค่า BMI ของคุณคือ: %.2f%n", bmi);

        // จัดหมวดหมู่ด้วย if-else-if แบบลำดับขั้น
        if (bmi < 18.5) {
            System.out.println("น้ำหนักน้อย (Underweight)");
        } else if (bmi < 25.0) {
            System.out.println("น้ำหนักปกติ (Normal)");
        } else if (bmi < 30.0) {
            System.out.println("น้ำหนักเกิน (Overweight)");
        } else {
            System.out.println("โรคอ้วน (Obesity)");
        }

        input.close();
    }
}
