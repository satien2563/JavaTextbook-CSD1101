package chap03_io;

import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ความยาวฐาน (เซนติเมตร): ");
        double base = sc.nextDouble();

        System.out.print("ความสูง (เซนติเมตร): ");
        double height = sc.nextDouble();

        double area = 0.5 * base * height;

        System.out.printf("พื้นที่สามเหลี่ยม = %.2f ตารางเซนติเมตร\n", area);

        sc.close();
    }
}
