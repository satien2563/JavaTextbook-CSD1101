package chap07_Method;

public class Ex7_3d_PrintReceipt {
    // เมธอดแบบ void สำหรับพิมพ์ใบเสร็จ
    public static void printReceipt(String item, double price) {
        System.out.println("==== ใบเสร็จรับเงิน ====");
        System.out.println("สินค้า: " + item);
        System.out.println("ราคา: " + price + " บาท");
        System.out.println("ขอบคุณที่ใช้บริการ");
    }

    public static void main(String[] args) {
        // เรียกใช้เมธอดเพื่อพิมพ์ใบเสร็จ
        printReceipt("หนังสือ Java", 350.0);
   }
}
