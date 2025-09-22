package chap07_Method;

public class Ex7_3c_VatCalculator {
    // เมธอดคำนวณราคาพร้อมภาษีมูลค่าเพิ่ม 7%
    public static double calculateVat(double price) {
        return price * 1.07;
    }

    public static void main(String[] args) {
        double price = 1000.0;
        double total = calculateVat(price);
        System.out.println("ราคาสินค้ารวม VAT: " + total + " บาท");
    }
}
