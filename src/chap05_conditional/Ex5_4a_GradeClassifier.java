package chap05_conditional;

import java.util.Scanner;

public class Ex5_4a_GradeClassifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมจัดเกรดคะแนน");

        // รับค่าคะแนน
        System.out.print("กรุณากรอกคะแนน (0-100): ");
        int score = input.nextInt();

        // จัดเกรดด้วย if-else-if แบบลำดับขั้น
        if (score >= 90) {
            System.out.println("เกรด A");
        } else if (score >= 80) {
            System.out.println("เกรด B");
        } else if (score >= 70) {
            System.out.println("เกรด C");
        } else if (score >= 60) {
            System.out.println("เกรด D");
        } else {
            System.out.println("เกรด F");
        }

        input.close();
    }
}
