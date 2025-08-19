package chap05_conditional;

import java.util.Scanner;

public class Ex5_6b_DiscountChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบสิทธิ์รับส่วนลด");

        //รับค่า เป็นสมาชิกหรือไม่ และ ยอดซื้อสินค้า
        System.out.print("คุณเป็นสมาชิกใช่หรือไม่ (true/false): ");
        boolean isMember = input.nextBoolean();

        System.out.print("ยอดซื้อสินค้า (บาท): ");
        double amount = input.nextDouble();

        //ใช้ if เพื่อตรวจสอบเงื่อนไข และ ใช้ || เชื่อมเงื่อนไข
        if (isMember || amount >= 1000) {
            System.out.println("คุณได้รับส่วนลดพิเศษ!");
        } else {
            System.out.println("คุณยังไม่เข้าเงื่อนไขส่วนลด");
        }

        input.close();
    }
}
