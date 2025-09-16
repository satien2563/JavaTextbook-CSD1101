package chap06_Iterator;

import java.util.Scanner;

public class Ex6_4b_SimpleCartTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ใส่จำนวนรายการสินค้า: ");
        int n = sc.nextInt();           // จำนวนรายการทั้งหมด
        sc.nextLine();                  // เคลียร์บรรทัด

        double subtotal = 0.0;          // ยอดรวมก่อนภาษี

        // ใช้ for วนรับข้อมูลแต่ละรายการ
        for (int i = 1; i <= n; i++) {
            System.out.println("\nรายการที่ " + i);

            System.out.print("ชื่อสินค้า: ");
            String name = sc.nextLine().trim();

            System.out.print("ราคาต่อหน่วย (บาท): ");
            double price = sc.nextDouble();

            System.out.print("จำนวน (หน่วย): ");
            int qty = sc.nextInt();
            sc.nextLine(); // เคลียร์บรรทัด

            // คำนวณยอดของแต่ละรายการ
            double lineTotal = price * qty;
            subtotal += lineTotal;

            // แสดงผลรายการย่อย
            System.out.printf(" -> %s x %d = %.2f บาท%n", name, qty, lineTotal);
        }

        // คำนวณภาษีและยอดสุทธิ
        final double VAT_RATE = 0.07;
        double vat = subtotal * VAT_RATE;
        double grandTotal = subtotal + vat;

        // สรุปผลลัพธ์
        System.out.println("\n--- สรุปยอด ---");
        System.out.printf("ยอดรวมก่อนภาษี: %.2f บาท%n", subtotal);
        System.out.printf("ภาษีมูลค่าเพิ่ม 7%%: %.2f บาท%n", vat);
        System.out.printf("ยอดสุทธิ: %.2f บาท%n", grandTotal);
    }
}
