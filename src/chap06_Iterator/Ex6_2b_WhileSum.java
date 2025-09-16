package chap06_Iterator;

import java.util.Scanner;

public class Ex6_2b_WhileSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int sum = 0;

        System.out.print("กรอกตัวเลขเพื่อหาผลรวม (0 = จบ): ");
        number = sc.nextInt();

        while (number != 0) {
            sum += number;
            System.out.print("กรอกตัวเลขอีกครั้ง (0 = จบ): ");
            number = sc.nextInt();
        }

        System.out.println("ผลรวมทั้งหมด = " + sum);
    }
}
