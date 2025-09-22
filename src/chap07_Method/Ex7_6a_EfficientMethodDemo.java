package chap07_Method;

public class Ex7_6a_EfficientMethodDemo {
    // เมธอดแบบไม่ดี: ชื่อกำกวมและทำงานหลายอย่าง
    public static void process(int price, int qty, double discount) {
        double total = price * qty;
        total -= total * discount;
        System.out.println("ยอดชำระ: " + total);
    }

    // เมธอดที่ออกแบบใหม่: ชื่อชัดเจนและแยกหน้าที่
    public static double calculateTotal(int price, int qty, double discount) {
        double total = price * qty;
        return total - (total * discount);
    }

    public static void printReceipt(double total) {
        System.out.println("=== ใบเสร็จรับเงิน ===");
        System.out.println("ยอดชำระ: " + total + " บาท");
    }

    public static void main(String[] args) {
        // เรียกใช้เมธอดที่ปรับปรุงแล้ว
        double total = calculateTotal(100, 3, 0.1); // 10% ส่วนลด
        printReceipt(total);
    }
}
