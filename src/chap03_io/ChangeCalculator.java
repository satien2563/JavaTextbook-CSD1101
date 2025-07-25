package chap03_io;

import java.util.Scanner;

public class ChangeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ราคาสินค้า (บาท): ");
        double price = sc.nextDouble();

        System.out.print("จำนวนเงินที่ลูกค้าชำระ (บาท): ");
        double paid = sc.nextDouble();

        double change = paid - price;

        if (change < 0) {
            System.out.println("จำนวนเงินไม่เพียงพอ กรุณาชำระเพิ่ม");
        } else {
            System.out.printf("เงินทอน = %.2f บาท\n", change);
        }

        sc.close();
    }
}
