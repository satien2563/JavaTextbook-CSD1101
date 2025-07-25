package chap03_io;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("คะแนนกลางภาค (30 คะแนน): ");
        double midterm = sc.nextDouble();

        System.out.print("คะแนนปลายภาค (40 คะแนน): ");
        double finalExam = sc.nextDouble();

        System.out.print("คะแนนแบบฝึกหัด (30 คะแนน): ");
        double assignments = sc.nextDouble();

        double total = midterm + finalExam + assignments;
        System.out.printf("คะแนนรวม = %.2f\n", total);

        String grade;
        if (total >= 80) grade = "A";
        else if (total >= 70) grade = "B";
        else if (total >= 60) grade = "C";
        else if (total >= 50) grade = "D";
        else grade = "F";

        System.out.println("ผลการเรียน: " + grade);
        sc.close();
    }
}
