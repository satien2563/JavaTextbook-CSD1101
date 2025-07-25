package chap03_io;

import java.util.Scanner;

public class SalesCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับข้อมูลสินค้า
        System.out.print("กรอกชื่อสินค้า: ");
        String productName = input.nextLine();

        System.out.print("กรอกจำนวนที่ซื้อ: ");
        int quantity = input.nextInt();

        System.out.print("กรอกราคาต่อหน่วย (บาท): ");
        double unitPrice = input.nextDouble();

        // คำนวณราคารวม
        double total = quantity * unitPrice;

        // ส่วนลด: หากซื้อเกิน 5 ชิ้น ให้ลด 10%
        double discount = 0;
        if (quantity >= 5) {
            discount = total * 0.10;
        }

        double netTotal = total - discount;

        // แสดงผล
        System.out.println("\n=== ใบเสร็จสินค้า ===");
        System.out.println("สินค้า: " + productName);
        System.out.println("จำนวน: " + quantity + " ชิ้น");
        System.out.println("ราคารวม: " + total + " บาท");

        if (discount > 0) {
            System.out.println("ส่วนลด: " + discount + " บาท");
        }

        System.out.println("ราคาสุทธิ: " + netTotal + " บาท");

        // ตรวจสอบว่าเป็นเลขคู่หรือคี่
        if (quantity % 2 == 0) {
            System.out.println("จำนวนที่ซื้อเป็นเลขคู่");
        } else {
            System.out.println("จำนวนที่ซื้อเป็นเลขคี่");
        }
    }
}
