package chap06_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6_5b_StudentScoreAnalyzer {

    // คลาสง่าย ๆ สำหรับเก็บข้อมูลนักศึกษา
    static class Student {
        String name;
        double score;
        Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("จำนวนนักศึกษาที่จะบันทึก: ");
        int n = readPositiveInt(sc);

        // รับข้อมูลนักศึกษา n คน
        for (int i = 1; i <= n; i++) {
            System.out.println("\nนักศึกษาคนที่ " + i);
            System.out.print("ชื่อ: ");
            String name = sc.next().trim();
            System.out.print("คะแนน (0-100): ");
            double score = readScore(sc);
            students.add(new Student(name, score));
        }

        // --- ใช้ for-each เพื่อคำนวณสรุป ---
        double sum = 0;
        int passCount = 0;
        final double PASS = 50.0;

        Student top = null;   // ผู้ที่ได้คะแนนสูงสุด

        for (Student st : students) {              // for-each เดินรายการนักศึกษาทั้งหมด
            sum += st.score;                       // สะสมคะแนน
            if (st.score >= PASS) passCount++;     // นับจำนวนผู้ผ่านเกณฑ์

            if (top == null || st.score > top.score) { // หา Top score
                top = st;
            }
        }

        double avg = sum / students.size();

        System.out.println("\nสรุปผลคะแนน");
        System.out.printf("ค่าเฉลี่ยทั้งชั้น: %.2f%n", avg);
        System.out.printf("จำนวนผู้ผ่านเกณฑ์ (>= %.1f): %d%n", PASS, passCount);
        System.out.printf("ผู้ได้คะแนนสูงสุด: %s (%.2f)%n", top.name, top.score);
    }

    // ---------- Helpers ----------
    private static int readPositiveInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                if (v > 0) return v;
            } else sc.next();
            System.out.print("กรอกจำนวนเต็มบวก: ");
        }
    }

    private static double readScore(Scanner sc) {
        while (true) {
            if (sc.hasNextDouble()) {
                double s = sc.nextDouble();
                if (s >= 0 && s <= 100) return s;
            } else sc.next();
            System.out.print("กรอกคะแนนช่วง 0-100: ");
        }
    }
}
