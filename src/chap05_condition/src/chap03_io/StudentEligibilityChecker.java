package chap03_io;
import java.util.Scanner;

public class StudentEligibilityChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับคะแนน
        System.out.print("กรอกคะแนนเก็บ (เต็ม 30): ");
        double scoreAssignment = input.nextDouble();

        System.out.print("กรอกคะแนนกลางภาค (เต็ม 30): ");
        double midterm = input.nextDouble();

        System.out.print("กรอกคะแนนปลายภาค (เต็ม 40): ");
        double finalExam = input.nextDouble();

        // รับจำนวนครั้งที่ขาดเรียน
        System.out.print("จำนวนครั้งที่ขาดเรียน: ");
        int absent = input.nextInt();

        // คำนวณคะแนนรวม
        double totalScore = scoreAssignment + midterm + finalExam;

        // ตรวจสอบสิทธิ์: ต้องได้คะแนนรวม ≥ 50 และขาดไม่เกิน 3 ครั้ง
        boolean isEligible = (totalScore >= 50) && (absent <= 3);

        System.out.println("\n=== ผลการตรวจสอบสิทธิ์ ===");
        System.out.println("คะแนนรวม: " + totalScore);
        System.out.println("จำนวนครั้งที่ขาดเรียน: " + absent);

        if (isEligible) {
            System.out.println("ผลการประเมิน: ผ่านเกณฑ์เข้าเรียน");
        } else {
            System.out.println("ผลการประเมิน: ไม่ผ่านเกณฑ์");
        }

        // เพิ่มจำนวนเข้าเรียน
        int attendance = 15 - absent;
        System.out.println("จำนวนครั้งที่เข้าเรียน: " + attendance);
    }
}
