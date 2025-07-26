package chap03_io;

public class DecimalPrecisionExample {
    public static void main(String[] args) {
        double pi = 3.14159265359;
        double price = 99.5;

        System.out.printf("ค่าของ Pi (2 ตำแหน่ง): %.2f\n", pi);
        System.out.printf("ค่าของ Pi (4 ตำแหน่ง): %.4f\n", pi);
        System.out.printf("ราคาสินค้า: %.2f บาท\n", price);
    }
}
